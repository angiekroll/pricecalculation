/**
 * Copyright 2023, Neoris. All rights reserved Date: 24/08/23
 */
package com.innoqa.pricecalculation.application.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author angiekroll@gmail.com - Ángela Carolina Castillo Rodríguez.
 * @version - 1.0.0
 * @since - 1.0.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceDTO {

  private String productId;
  private String brandId;
  private String priceId;
  private String startDate;
  private String endDate;
  private BigDecimal finalPrice;

}