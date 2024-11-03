package com.fullcycle.catalog_admin.application.category.create;

import com.fullcycle.catalog_admin.domain.category.Category;
import com.fullcycle.catalog_admin.domain.category.CategoryID;

public record CreateCategoryOutput(
    CategoryID id
) {

  public static CreateCategoryOutput from(Category category) {
    return new CreateCategoryOutput(category.getId());
  }
}
