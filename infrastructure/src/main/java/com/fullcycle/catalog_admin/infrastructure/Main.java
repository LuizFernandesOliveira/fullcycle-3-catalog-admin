package com.fullcycle.catalog_admin.infrastructure;

import com.fullcycle.catalog_admin.application.UseCase;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    System.out.println(new UseCase().execute());
  }
}