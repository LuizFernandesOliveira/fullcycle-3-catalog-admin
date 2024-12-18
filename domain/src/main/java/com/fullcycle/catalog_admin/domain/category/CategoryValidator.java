package com.fullcycle.catalog_admin.domain.category;

import com.fullcycle.catalog_admin.domain.validation.Error;
import com.fullcycle.catalog_admin.domain.validation.ValidationHandler;
import com.fullcycle.catalog_admin.domain.validation.Validator;

public class CategoryValidator extends Validator {
  public static final int NAME_MIN_LENGTH = 3;
  public static final int NAME_MAX_LENGTH = 255;
  private final Category category;


  public CategoryValidator(final Category category, final ValidationHandler handler) {
    super(handler);
    this.category = category;
  }

  @Override
  public void validate() {
    checkNameConstraints();
  }

  private void checkNameConstraints() {
    String name = this.category.getName();
    if (name == null) {
      this.validationHandler().append(new Error("'name' should not be null"));
      return;
    }

    if (name.isBlank()) {
      this.validationHandler().append(new Error("'name' should not be empty"));
      return;
    }

    int length = name.trim().length();
    if (length < NAME_MIN_LENGTH || length > NAME_MAX_LENGTH) {
      this.validationHandler().append(new Error("'name' must be between 3 and 255 characters"));
    }
  }
}
