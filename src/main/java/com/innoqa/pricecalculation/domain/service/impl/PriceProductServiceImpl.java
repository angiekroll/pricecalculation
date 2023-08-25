/**
 * Copyright 2023, Neoris. All rights reserved Date: 24/08/23
 */
package com.innoqa.pricecalculation.domain.service.impl;

import com.innoqa.pricecalculation.application.constans.NotificationCode;
import com.innoqa.pricecalculation.application.exception.PriceCalculationException;
import com.innoqa.pricecalculation.domain.model.Price;
import com.innoqa.pricecalculation.domain.service.PriceProductService;
import com.innoqa.pricecalculation.infrastructure.persistence.repository.PriceRepository;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author angiekroll@gmail.com - Ángela Carolina Castillo Rodríguez.
 * @version - 1.0.0
 * @since - 1.0.0
 */

@Service
@Slf4j
public class PriceProductServiceImpl implements PriceProductService {

  public final PriceRepository priceRepository;

  public PriceProductServiceImpl(PriceRepository priceRepository) {
    this.priceRepository = priceRepository;
  }

  @Override
  public Price getPrice(LocalDateTime applicationDate, Long productId, Long brandId)
      throws PriceCalculationException {

    List<Price> prices = priceRepository.findPricesByProductIdAndBrandIdAndApplicationDate(
        productId, brandId, applicationDate);

    if (prices.isEmpty()) {
      throw new PriceCalculationException(NotificationCode.PRICES_NOT_FOUND);
    }

    return getHighestPriorityPrice(prices);

  }

  private Price getHighestPriorityPrice(List<Price> prices) throws PriceCalculationException {
    return prices.stream()
        .max(Comparator.comparingInt(Price::getPriority))
        .orElseThrow(() -> new PriceCalculationException(NotificationCode.PRIORITY_NOT_SET));
  }

}