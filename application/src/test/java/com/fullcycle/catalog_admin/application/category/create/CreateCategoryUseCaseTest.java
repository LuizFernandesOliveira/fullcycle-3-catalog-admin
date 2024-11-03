package com.fullcycle.catalog_admin.application.category.create;

import com.fullcycle.catalog_admin.domain.category.CategoryGateway;
import com.fullcycle.catalog_admin.domain.exception.DomainException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateCategoryUseCaseTest {
  @InjectMocks
  private DefaultCreateCategoryUseCase useCase;

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

  @Test
  void givenAInvalidName_whenCallsCreateCategory_thenShouldDomainException() {
    final var expectedName = "";
    final var expectedDescription = "Category Description";
    final var expectedIsActive = true;

    final var command = CreateCategoryCommand.with(expectedName, expectedDescription, expectedIsActive);

    assertThrows(DomainException.class, () -> useCase.execute(command));

    verify(categoryGateway, never()).create(any());
  }
}