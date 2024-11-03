package com.fullcycle.catalog_admin.application.category.create;

import com.fullcycle.catalog_admin.domain.category.CategoryGateway;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateCategoryUseCaseTest {
  @Mock
  private CategoryGateway categoryGateway;

  @Test
  void givenAValidCommand_whenCallsCreateCategory_shouldReturnCategoryID() {
    final var expectedName = "Category Name";
    final var expectedDescription = "Category Description";
    final var expectedIsActive = true;

    final var command = CreateCategoryCommand.with(expectedName, expectedDescription, expectedIsActive);
    when(categoryGateway.create(any()))
        .thenAnswer(AdditionalAnswers.returnsFirstArg());

    final var useCase = new DefaultCreateCategoryUseCase(categoryGateway);
    final var actualOutput = useCase.execute(command);
    assertNotNull(actualOutput);
    assertNotNull(actualOutput.id());
    verify(categoryGateway).create(argThat(category -> {
      return Objects.equals(category.getName(), expectedName) &&
          Objects.equals(category.getDescription(), expectedDescription) &&
          Objects.equals(category.isActive(), expectedIsActive) &&
          Objects.nonNull(category.getCreatedAt()) &&
          Objects.nonNull(category.getUpdatedAt()) &&
          Objects.isNull(category.getDeletedAt());
    }));
  }
}