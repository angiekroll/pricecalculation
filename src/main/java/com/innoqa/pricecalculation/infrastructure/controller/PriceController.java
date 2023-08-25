/**
 * Copyright 2023, Neoris. All rights reserved Date: 24/08/23
 */
package com.innoqa.pricecalculation.infrastructure.controller;

import com.innoqa.pricecalculation.application.dto.PriceDTO;
import com.innoqa.pricecalculation.application.exception.PriceCalculationException;
import com.innoqa.pricecalculation.application.usecase.PriceProductUseCase;
import com.innoqa.pricecalculation.infrastructure.constans.EndpointsResources;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
@Validated
public class PriceController {

  private final PriceProductUseCase priceProductUseCase;

  public PriceController(PriceProductUseCase priceProductUseCase) {
    this.priceProductUseCase = priceProductUseCase;
  }

  @Operation(summary = "Get the price of a product")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successful operation", content = {
          @Content(mediaType = "application/json", schema = @Schema(implementation = PriceDTO.class))
      }),
      @ApiResponse(responseCode = "404", description = "Price not found", content = @Content),
      @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
  })

  @GetMapping
  public ResponseEntity<PriceDTO> getPrice(
      @RequestParam(name = "applicationDate") @NotNull @NotBlank String applicationDate,
      @RequestParam(name = "productId") @NotNull @Positive Long productId,
      @RequestParam(name = "brandId") @NotNull @Positive Long brandId)
      throws PriceCalculationException {
    PriceDTO priceDTO = priceProductUseCase.getProductPrice(applicationDate, productId, brandId);
    return ResponseEntity.ok(priceDTO);
  }

}