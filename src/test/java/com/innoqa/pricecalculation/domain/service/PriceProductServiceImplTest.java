/**
 * Copyright 2023, Neoris. All rights reserved Date: 24/08/23
 */
package com.innoqa.pricecalculation.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

import com.innoqa.pricecalculation.application.exception.PriceCalculationException;
import com.innoqa.pricecalculation.domain.model.Brand;
import com.innoqa.pricecalculation.domain.model.Price;
import com.innoqa.pricecalculation.domain.model.Product;
import com.innoqa.pricecalculation.domain.service.impl.PriceProductServiceImpl;
import com.innoqa.pricecalculation.infrastructure.persistence.repository.PriceRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * @author angiekroll@gmail.com - Ángela Carolina Castillo Rodríguez.
 * @version - 1.0.0
 * @since - 1.0.0
 */

@RunWith(MockitoJUnitRunner.class)
class PriceProductServiceImplTest {

  @Mock
  private PriceRepository priceRepository;

  @InjectMocks
  private PriceProductServiceImpl priceProductServiceImpl;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void givenApplicationDateWhitDay14AndTime16_WhenGetPrice_ThenValidatePriorityAndReturnPriceIdTwo()
      throws Exception {
    LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 16, 0, 0);
    Long productId = 35455L;
    Long brandId = 1L;

    Mockito.when(priceRepository.findPricesByProductIdAndBrandIdAndApplicationDate(
        anyLong(), anyLong(), any(LocalDateTime.class))).thenReturn(buildPrices());

    Price result = priceProductServiceImpl.getPrice(applicationDate, productId, brandId);

    assertEquals(35455L, result.getProduct().getId());
    assertEquals(1L, result.getBrand().getId());
    assertEquals(2L, result.getId());
    assertEquals(BigDecimal.valueOf(25.45), result.getFinalPrice());
  }

  @Test
  void givenAProductIdDoesNotExist_WhenGetPrice_ThenReturnExceptionNotFound() throws Exception {
    LocalDateTime applicationDate = LocalDateTime.now();
    Long productId = 123L;
    Long brandId = 456L;

    Mockito.when(priceRepository.findPricesByProductIdAndBrandIdAndApplicationDate(
            Mockito.anyLong(), Mockito.anyLong(), Mockito.any(LocalDateTime.class)))
        .thenReturn(Collections.emptyList());

    Assertions.assertThrows(PriceCalculationException.class, () ->
        priceProductServiceImpl.getPrice(applicationDate, productId, brandId)
    );

  }

  private List<Price> buildPrices() {
    Product product = Product.builder().id(35455L).build();
    Brand brand = Brand.builder().id(1L).build();

    List<Price> prices = new ArrayList<>();

    prices.add(
        Price.builder().id(1L).product(product).brand(brand)
            .startDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0))
            .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
            .finalPrice(BigDecimal.valueOf(35.50))
            .currency("EUR")
            .priority(0).build());

    prices.add(Price.builder().id(2L).product(product).brand(brand)
        .startDate(LocalDateTime.of(2020, 6, 14, 15, 0, 0))
        .endDate(LocalDateTime.of(2020, 6, 14, 18, 30, 0))
        .finalPrice(BigDecimal.valueOf(25.45))
        .currency("EUR")
        .priority(1).build());

    return prices;

  }

}