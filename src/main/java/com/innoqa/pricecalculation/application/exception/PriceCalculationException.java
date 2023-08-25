/**
 * Copyright 2023, Neoris. All rights reserved Date: 24/08/23
 */
package com.innoqa.pricecalculation.application.exception;

import com.innoqa.pricecalculation.application.constans.NotificationCode;
import lombok.Getter;

/**
 *
 * @author angiekroll@gmail.com - Ángela Carolina Castillo Rodríguez.
 * @version - 1.0.0
 * @since - 1.0.0
 */
public class PriceCalculationException extends Exception {
  @Getter
  private final NotificationCode errorCode;

  public PriceCalculationException(NotificationCode errorCode) {
    super(errorCode.getDescription());
    this.errorCode = errorCode;
  }

  public PriceCalculationException(NotificationCode errorCode, Throwable cause) {
    super(errorCode.getDescription(), cause);
    this.errorCode = errorCode;
  }

}