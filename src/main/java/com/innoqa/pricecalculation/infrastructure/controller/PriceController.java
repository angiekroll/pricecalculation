/**
 * Copyright 2023, Neoris. All rights reserved Date: 24/08/23
 */
package com.innoqa.pricecalculation.infrastructure.controller;

import com.innoqa.pricecalculation.application.dto.PriceDTO;
import com.innoqa.pricecalculation.application.exception.PriceCalculationException;
import com.innoqa.pricecalculation.application.usecase.PriceProductUseCase;
import com.innoqa.pricecalculation.infrastructure.constans.EndpointsResources;
import java.time.LocalDateTime;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author angiekroll@gmail.com - Ángela Carolina Castillo Rodríguez.
 * @version - 1.0.0
 * @since - 1.0.0
 */

@RestController
@RequestMapping(EndpointsResources.PRICES)
public class PriceController {

  private final PriceProductUseCase priceProductUseCase;

  public PriceController(PriceProductUseCase priceProductUseCase) {
    this.priceProductUseCase = priceProductUseCase;
  }

  @GetMapping
  public ResponseEntity<PriceDTO> getPrice(
      @RequestParam("applicationDate") String applicationDate,
      @RequestParam("productId") String productId,
      @RequestParam("brandId") String brandId) throws PriceCalculationException {
    PriceDTO priceDTO = priceProductUseCase.getProductPrice(applicationDate, productId, brandId);
    return ResponseEntity.ok(priceDTO);
  }

}