package com.fullcycle.catalog_admin.domain.category;

import com.fullcycle.catalog_admin.domain.Identifier;

import java.util.Objects;
import java.util.UUID;

public class CategoryID extends Identifier {
  private final String value;

  private CategoryID(final String value) {
    Objects.requireNonNull(value, "'value' should not be null");
    this.value = value;
  }

  public static CategoryID unique() {
    return CategoryID.from(java.util.UUID.randomUUID());
  }

  public static CategoryID from(final String anId) {
    return new CategoryID(anId);
  }

  public static CategoryID from(final UUID anId) {
    return new CategoryID(anId.toString());
  }

  public String getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CategoryID that = (CategoryID) o;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }
}
