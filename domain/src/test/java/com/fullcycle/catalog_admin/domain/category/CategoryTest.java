package com.fullcycle.catalog_admin.domain.category;

import com.fullcycle.catalog_admin.domain.exception.DomainException;
import com.fullcycle.catalog_admin.domain.validation.handler.Handler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

  @Test
  void givenAValidParams_whenCallNewCategory_thenInstantiateACategory() {
    final var expectedName = "Filmes";
    final var expectedDescription = "A categoria mais assistida";
    final var expectedIsActive = true;

    final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedIsActive);
    actualCategory.validate(Handler.THROWS_VALIDATION);
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
    final var actualException = assertThrows(DomainException.class, () -> actualCategory.validate(Handler.THROWS_VALIDATION));

    assertEquals(expectedErrorCount, actualException.getErrors().size());
    assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
  }

  @Test
  void givenAnInvalidEmptyName_whenCallNewCategoryAndValidate_thenShouldReturnError() {
    final var expectedErrorCount = 1;
    final var expectedErrorMessage = "'name' should not be empty";
    final String expectedName = "    ";
    final var expectedDescription = "A categoria mais assistida";
    final var expectedIsActive = true;

    final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedIsActive);
    final var actualException = assertThrows(DomainException.class, () -> actualCategory.validate(Handler.THROWS_VALIDATION));

    assertEquals(expectedErrorCount, actualException.getErrors().size());
    assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
  }

  @Test
  void givenAnInvalidNameLengthLessThan3_whenCallNewCategoryAndValidate_thenShouldReturnError() {
    final var expectedErrorCount = 1;
    final var expectedErrorMessage = "'name' must be between 3 and 255 characters";
    final String expectedName = "Fi ";
    final var expectedDescription = "A categoria mais assistida";
    final var expectedIsActive = true;

    final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedIsActive);
    final var actualException = assertThrows(DomainException.class, () -> actualCategory.validate(Handler.THROWS_VALIDATION));

    assertEquals(expectedErrorCount, actualException.getErrors().size());
    assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
  }

  @Test
  void givenAnInvalidNameLengthMoreThan255_whenCallNewCategoryAndValidate_thenShouldReturnError() {
    final var expectedErrorCount = 1;
    final var expectedErrorMessage = "'name' must be between 3 and 255 characters";
    final String expectedName = """
        Evidentemente, a estrutura atual da organização nos obriga à análise do retorno esperado a longo prazo.
        Do mesmo modo, a contínua expansão de nossa atividade não pode mais se dissociar da gestão inovadora da
        qual fazemos parte. Gostaria de enfatizar que o entendimento das metas propostas assume importantes
        """;
    final var expectedDescription = "A categoria mais assistida";
    final var expectedIsActive = true;

    final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedIsActive);
    final var actualException = assertThrows(DomainException.class, () -> actualCategory.validate(Handler.THROWS_VALIDATION));

    assertEquals(expectedErrorCount, actualException.getErrors().size());
    assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
  }

  @Test
  void givenAValidIsActiveFalse_whenCallNewCategoryAndValidate_thenShouldReturnDeletedAt() {
    final var expectedName = "Filmes";
    final var expectedDescription = "A categoria mais assistida";
    final var expectedIsActive = false;

    final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedIsActive);
    assertNotNull(actualCategory);
    assertNotNull(actualCategory.getId());
    assertEquals(expectedName, actualCategory.getName());
    assertEquals(expectedDescription, actualCategory.getDescription());
    assertEquals(expectedIsActive, actualCategory.isActive());
    assertNotNull(actualCategory.getCreatedAt());
    assertNotNull(actualCategory.getUpdatedAt());
    assertNotNull(actualCategory.getDeletedAt());
  }
}