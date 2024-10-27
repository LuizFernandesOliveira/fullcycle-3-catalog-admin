package com.fullcycle.catalog_admin.domain.category;

import com.fullcycle.catalog_admin.domain.AggregateRoot;
import com.fullcycle.catalog_admin.domain.validation.ValidationHandler;

import java.time.Instant;

public class Category extends AggregateRoot<CategoryID> {
  private final String name;
  private final String description;
  private final boolean isActive;
  private final Instant createdAt;
  private final Instant updatedAt;
  private final Instant deletedAt;

  private Category(
      final CategoryID anId,
      final String aName,
      final String aDescription,
      final boolean isActive,
      final Instant aCreatedAt,
      final Instant aUpdatedAt,
      final Instant aDeletedAt) {
    super(anId);
    this.name = aName;
    this.description = aDescription;
    this.isActive = isActive;
    this.createdAt = aCreatedAt;
    this.updatedAt = aUpdatedAt;
    this.deletedAt = aDeletedAt;
  }

  public static Category newCategory(String name, String description, boolean isActive) {
    final var id = CategoryID.unique();
    final var now = Instant.now();
    final var deletedAt = isActive ? null : now;
    return new Category(id, name, description, isActive, now, now, deletedAt);
  }

  @Override
  public void validate(ValidationHandler handler) {
    new CategoryValidator(this, handler).validate();
  }

  public CategoryID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public boolean isActive() {
    return isActive;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public Instant getDeletedAt() {
    return deletedAt;
  }
}