package com.fullcycle.catalog_admin.domain.validation.handler;

import com.fullcycle.catalog_admin.domain.exception.DomainException;
import com.fullcycle.catalog_admin.domain.validation.Error;
import com.fullcycle.catalog_admin.domain.validation.ValidationHandler;

import java.util.List;

public class ThrowsValidationHandler implements ValidationHandler {

  @Override
  public ValidationHandler append(final Error anError) {
    throw DomainException.with(List.of(anError));
  }

  @Override
  public ValidationHandler append(final ValidationHandler anHandler) {
    throw DomainException.with(anHandler.getErrors());
  }

  @Override
  public List<Error> getErrors() {
    return List.of();
  }
}
