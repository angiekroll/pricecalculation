/**
 * Copyright 2023, Neoris. All rights reserved Date: 24/08/23
 */
package com.innoqa.pricecalculation.domain.service;

import com.innoqa.pricecalculation.application.exception.PriceCalculationException;
import com.innoqa.pricecalculation.domain.model.Price;
import java.time.LocalDateTime;

/**
 * @author angiekroll@gmail.com - Ángela Carolina Castillo Rodríguez.
 * @version - 1.0.0
 * @since - 1.0.0
 */

public interface PriceProductService {

  Price getPrice(LocalDateTime applicationDate, Long productId, Long brandId)
      throws PriceCalculationException;

}