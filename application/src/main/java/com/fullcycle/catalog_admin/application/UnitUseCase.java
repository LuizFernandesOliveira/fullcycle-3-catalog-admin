package com.fullcycle.catalog_admin.application;


public abstract class UnitUseCase<IN> {

  public abstract void execute(IN input);
}