package com.fullcycle.catalog_admin.domain.category;

import com.fullcycle.catalog_admin.domain.AggregateRoot;
import com.fullcycle.catalog_admin.domain.validation.ValidationHandler;

import java.time.Instant;

public class Category extends AggregateRoot<CategoryID> {
  private String name;
  private String description;
  private boolean active;
  private final Instant createdAt;
  private Instant updatedAt;
  private Instant deletedAt;

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
    this.active = isActive;
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

  public Category activate() {
    this.deletedAt = null;
    this.active = true;
    this.updatedAt = Instant.now();
    return this;
  }

  public Category deactivate() {
    if (getDeletedAt() == null) {
      this.deletedAt = Instant.now();
    }
    this.active = false;
    this.updatedAt = Instant.now();
    return this;
  }

  public Category update(
      final String aName,
      final String aDescriptions,
      final boolean isActive
  ) {
    this.name = aName;
    this.description = aDescriptions;
    if (isActive) {
      return activate();
    } else {
      return deactivate();
    }
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public boolean isActive() {
    return active;
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