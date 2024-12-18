package com.fullcycle.catalog_admin.domain.validation;

import java.util.List;

public interface ValidationHandler {

  ValidationHandler append(final Error anError);
  ValidationHandler append(final ValidationHandler anHandler);
  List<Error> getErrors();

  default boolean hasError() {
    return getErrors() != null && !getErrors().isEmpty();
  }
}
