package com.fullcycle.catalog_admin.domain.validation.handler;

import com.fullcycle.catalog_admin.domain.validation.ValidationHandler;

public class Handler {
  public static final ValidationHandler THROWS_VALIDATION = new ThrowsValidationHandler();

  private Handler() {}
}
