/**
 * Copyright 2023, Neoris. All rights reserved Date: 24/08/23
 */
package com.innoqa.pricecalculation.infrastructure.persistence.repository;

import com.innoqa.pricecalculation.domain.model.Price;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author angiekroll@gmail.com - Ángela Carolina Castillo Rodríguez.
 * @version - 1.0.0
 * @since - 1.0.0
 */

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

  @Query("SELECT p FROM Price p " +
      "WHERE p.product.id = :productId " +
      "AND p.brand.id = :brandId " +
      "AND :applicationDate BETWEEN p.startDate AND p.endDate")
  List<Price> findPricesByProductIdAndBrandIdAndApplicationDate(
      @Param("productId") Long productId,
      @Param("brandId") Long brandId,
      @Param("applicationDate") LocalDateTime applicationDate
  );

}