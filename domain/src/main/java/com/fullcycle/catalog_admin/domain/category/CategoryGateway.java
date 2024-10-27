package com.fullcycle.catalog_admin.domain.category;

import com.fullcycle.catalog_admin.domain.pagination.Pagination;

public interface CategoryGateway {
  Category create(final Category category);
  Category update(final Category category);
  Category findById(final CategoryID id);
  void delete(final CategoryID id);
  Pagination<Category> findAll(CategorySearchQuery query);
}
