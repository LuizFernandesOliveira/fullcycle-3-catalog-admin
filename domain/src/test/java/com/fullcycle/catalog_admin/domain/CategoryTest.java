package com.fullcycle.catalog_admin.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

  @Test
  void test() {
    Category category = new Category();
    assertNotNull(category);
  }
}