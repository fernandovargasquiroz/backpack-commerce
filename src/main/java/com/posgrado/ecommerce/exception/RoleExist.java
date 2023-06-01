package com.posgrado.ecommerce.exception;

public class RoleExist extends RuntimeException {

  private static final String ERROR_MESSAGE = "The role %s has already been registered.";

  public RoleExist(String name) {
    super(String.format(ERROR_MESSAGE, name));
  }
}
