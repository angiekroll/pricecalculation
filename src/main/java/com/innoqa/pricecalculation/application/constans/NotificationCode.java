/**
 * Copyright 2023, Neoris. All rights reserved Date: 24/08/23
 */
package com.innoqa.pricecalculation.application.constans;

import org.springframework.http.HttpStatus;

/**
 * @author angiekroll@gmail.com - Ángela Carolina Castillo Rodríguez.
 * @version - 1.0.0
 * @since - 1.0.0
 */
public enum NotificationCode {
  PRICES_NOT_FOUND("Prices not found.", HttpStatus.NOT_FOUND),
  PRIORITY_NOT_SET("There is no established maximum priority, validate parametry",
      HttpStatus.PRECONDITION_FAILED);

  private final HttpStatus httpStatus;
  private final String message;

  NotificationCode(String message, HttpStatus httpStatus) {
    this.message = message;
    this.httpStatus = httpStatus;
  }

  public String getDescription() {
    return message;
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

}