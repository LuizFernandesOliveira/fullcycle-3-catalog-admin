package com.fullcycle.catalog_admin.domain.exception;

import java.util.List;
import com.fullcycle.catalog_admin.domain.validation.Error;

public class DomainException extends NoStacktraceException {
  private final List<Error> errors;

  private DomainException(final List<Error> errors) {
    super("");
    this.errors = errors;
  }

  public static DomainException with(final List<Error> errors) {
    return new DomainException(errors);
  }

  public List<Error> getErrors() {
    return this.errors;
  }
}
