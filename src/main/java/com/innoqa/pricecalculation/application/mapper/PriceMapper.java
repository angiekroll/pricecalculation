/**
 * Copyright 2023, Neoris. All rights reserved Date: 24/08/23
 */
package com.innoqa.pricecalculation.application.mapper;

import com.innoqa.pricecalculation.application.dto.PriceDTO;
import com.innoqa.pricecalculation.domain.model.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author angiekroll@gmail.com - Ángela Carolina Castillo Rodríguez.
 * @version - 1.0.0
 * @since - 1.0.0
 */

@Mapper
public interface PriceMapper {

  PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

  @Mapping(source = "product.id", target = "productId")
  @Mapping(source = "brand.id", target = "brandId")
  @Mapping(source = "id", target = "priceId")
  PriceDTO priceToPriceDTO(Price price);

}