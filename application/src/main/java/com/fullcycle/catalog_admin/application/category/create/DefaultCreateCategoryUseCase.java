package com.fullcycle.catalog_admin.application.category.create;

import com.fullcycle.catalog_admin.domain.category.Category;
import com.fullcycle.catalog_admin.domain.category.CategoryGateway;
import com.fullcycle.catalog_admin.domain.validation.handler.ThrowsValidationHandler;

public class DefaultCreateCategoryUseCase extends CreateCategoryUseCase {
  private final CategoryGateway categoryGateway;

  public DefaultCreateCategoryUseCase(final CategoryGateway categoryGateway) {
    this.categoryGateway = categoryGateway;
  }

  @Override
  public CreateCategoryOutput execute(final CreateCategoryCommand input) {
    String aName = input.name();
    String aDescription = input.description();
    boolean isActive = input.isActive();

    Category category = Category.newCategory(aName, aDescription, isActive);
    category.validate(new ThrowsValidationHandler());

    return CreateCategoryOutput.from(this.categoryGateway.create(category));
  }
}
