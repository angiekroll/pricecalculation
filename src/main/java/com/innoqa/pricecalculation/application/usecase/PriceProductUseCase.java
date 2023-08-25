/**
 * Copyright 2023, Neoris. All rights reserved Date: 24/08/23
 */
package com.innoqa.pricecalculation.application.usecase;

import com.innoqa.pricecalculation.application.dto.PriceDTO;
import com.innoqa.pricecalculation.application.exception.PriceCalculationException;

/**
 *
 * @author angiekroll@gmail.com - Ángela Carolina Castillo Rodríguez.
 * @version - 1.0.0
 * @since - 1.0.0
 */
public interface PriceProductUseCase {

  PriceDTO getProductPrice(String date, Long productId, Long brandId)
      throws PriceCalculationException;

}