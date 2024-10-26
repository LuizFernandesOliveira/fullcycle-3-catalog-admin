package com.fullcycle.catalog_admin.domain.category;

import com.fullcycle.catalog_admin.domain.exception.DomainException;
import com.fullcycle.catalog_admin.domain.validation.handler.ThrowsValidationHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

  @Test
  void givenAValidParams_whenCallNewCategory_thenInstantiateACategory() {
    final var expectedName = "Filmes";
    final var expectedDescription = "A categoria mais assistida";
    final var expectedIsActive = true;

    final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedIsActive);
    assertNotNull(actualCategory);
    assertNotNull(actualCategory.getId());
    assertEquals(expectedName, actualCategory.getName());
    assertEquals(expectedDescription, actualCategory.getDescription());
    assertEquals(expectedIsActive, actualCategory.isActive());
    assertNotNull(actualCategory.getCreatedAt());
    assertNotNull(actualCategory.getUpdatedAt());
    assertNull(actualCategory.getDeletedAt());
  }

  @Test
  void givenAnInvalidNullName_whenCallNewCategoryAndValidate_thenShouldReturnError() {
    final var expectedErrorCount = 1;
    final var expectedErrorMessage = "'name' should not be null";
    final String expectedName = null;
    final var expectedDescription = "A categoria mais assistida";
    final var expectedIsActive = true;

    final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedIsActive);
    final var actualException = assertThrows(DomainException.class, () -> actualCategory.validate(new ThrowsValidationHandler()));

    assertEquals(expectedErrorCount, actualException.getErrors().size());
    assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
  }
}