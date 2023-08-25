/**
 * Copyright 2023, Neoris. All rights reserved Date: 24/08/23
 */
package com.innoqa.pricecalculation.application.usecase.impl;

import com.innoqa.pricecalculation.application.dto.PriceDTO;
import com.innoqa.pricecalculation.application.exception.PriceCalculationException;
import com.innoqa.pricecalculation.application.mapper.PriceMapper;
import com.innoqa.pricecalculation.application.usecase.PriceProductUseCase;
import com.innoqa.pricecalculation.domain.model.Price;
import com.innoqa.pricecalculation.domain.service.PriceProductService;
import com.innoqa.pricecalculation.infrastructure.utils.DataConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author angiekroll@gmail.com - Ángela Carolina Castillo Rodríguez.
 * @version - 1.0.0
 * @since - 1.0.0
 */

@Slf4j
@Component
public class PriceProductUseCaseImpl implements PriceProductUseCase {

  public final PriceProductService priceProductService;

  public PriceProductUseCaseImpl(PriceProductService priceProductService) {
    this.priceProductService = priceProductService;
  }

  @Override
  public PriceDTO getProductPrice(String applicationDate, String productId, String brandId)
      throws PriceCalculationException {

    Price price = priceProductService.getPrice(DataConverter.parseToLocalDateTime(applicationDate),
        DataConverter.parseToLong(productId), DataConverter.parseToLong(brandId));

    return PriceMapper.INSTANCE.priceToPriceDTO(price);
  }
}