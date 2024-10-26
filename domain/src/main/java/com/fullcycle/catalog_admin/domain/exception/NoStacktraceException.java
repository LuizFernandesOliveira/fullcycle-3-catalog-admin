package com.fullcycle.catalog_admin.domain.exception;

public class NoStacktraceException extends RuntimeException {
  public NoStacktraceException(final String message) {
    super(message, null, true, false);
  }
}
