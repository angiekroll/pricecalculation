/**
 * Copyright 2023. All rights reserved Date: 24/08/23
 */
package com.innoqa.pricecalculation.infrastructure.persistence.repository;

import com.innoqa.pricecalculation.domain.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author angiekroll@gmail.com - Ángela Carolina Castillo Rodríguez.
 * @version - 1.0.0
 * @since - 1.0.0
 */

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

}