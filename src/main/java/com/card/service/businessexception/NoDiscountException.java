package com.card.service.businessexception;

/**
 * Card has no discount for requested store
 */
public class NoDiscountException extends RuntimeException {

  public NoDiscountException(String message) {
    super(message);
  }
}
