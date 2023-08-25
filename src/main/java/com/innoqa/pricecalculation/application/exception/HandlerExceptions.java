/**
 * Copyright 2023, Neoris. All rights reserved Date: 24/08/23
 */
package com.innoqa.pricecalculation.application.exception;

import com.innoqa.pricecalculation.application.dto.NotificationDTO;
import java.time.Instant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author angiekroll@gmail.com - Ángela Carolina Castillo Rodríguez.
 * @version - 1.0.0
 * @since - 1.0.0
 */

@RestControllerAdvice
@Slf4j
public class HandlerExceptions {

  @ExceptionHandler(PriceCalculationException.class)
  public ResponseEntity<Object> handlerUserFlowException(PriceCalculationException ex) {
    log.error("Exception: [{}]", ex.getErrorCode().getDescription(), ex);
    return new ResponseEntity<>(
        NotificationDTO.builder()
            .message(ex.getErrorCode().getDescription())
            .status(ex.getErrorCode().getHttpStatus().value())
            .error(ex.getErrorCode().getHttpStatus().getReasonPhrase())
            .timestamp(Instant.now())
            .build(),
        ex.getErrorCode().getHttpStatus());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<NotificationDTO> handlerException(Exception ex) {
    log.error("Unexpected exception: {}", ex.getMessage(), ex);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(NotificationDTO.builder()
            .message("Unexpected error occurred. " + ex.getMessage())
            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
            .timestamp(Instant.now())
            .build());
  }

}