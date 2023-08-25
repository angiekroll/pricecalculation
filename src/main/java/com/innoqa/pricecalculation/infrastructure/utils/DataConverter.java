/**
 * Copyright 2023, Neoris. All rights reserved Date: 24/08/23
 */
package com.innoqa.pricecalculation.infrastructure.utils;

import java.time.LocalDateTime;

/**
 * @author angiekroll@gmail.com - Ángela Carolina Castillo Rodríguez.
 * @version - 1.0.0
 * @since - 1.0.0
 */
public class DataConverter {

  private DataConverter() {}

  public static long parseToLong(String value) {
    return Long.parseLong(value);
  }

  public static LocalDateTime parseToLocalDateTime(String value) {
    return LocalDateTime.parse(value);
  }

}