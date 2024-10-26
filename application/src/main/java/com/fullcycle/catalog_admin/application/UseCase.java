package com.fullcycle.catalog_admin.application;

import com.fullcycle.catalog_admin.domain.category.Category;

public class UseCase {

  public Category execute() {
    return Category.newCategory(null, null,  false);
  }
}