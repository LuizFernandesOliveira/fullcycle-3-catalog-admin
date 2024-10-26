package com.fullcycle.catalog_admin.domain.category;

import com.fullcycle.catalog_admin.domain.validation.Error;
import com.fullcycle.catalog_admin.domain.validation.ValidationHandler;
import com.fullcycle.catalog_admin.domain.validation.Validator;

public class CategoryValidator extends Validator {
  private final Category category;


  public CategoryValidator(final Category category, final ValidationHandler handler) {
    super(handler);
    this.category = category;
  }

  @Override
  public void validate() {
    if (this.category.getName() == null) {
      this.validationHandler().append(new Error("'name' should not be null"));
    }
  }
}
