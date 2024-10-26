package com.fullcycle.catalog_admin.domain;

import com.fullcycle.catalog_admin.domain.validation.ValidationHandler;

import java.util.Objects;

public abstract class Entity<ID extends Identifier> {
  protected final ID id;

  protected Entity(final ID id) {
    Objects.requireNonNull(id, "'id' should not be null");
    this.id = id;
  }

  public abstract void validate(final ValidationHandler handler);

  public ID getId() {
    return id;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Entity<?> entity = (Entity<?>) obj;
    return getId().equals(entity.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }
}
