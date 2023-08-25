/**
 * Copyright 2023, Neoris. All rights reserved Date: 24/08/23
 */
package com.innoqa.pricecalculation.infrastructure.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author angiekroll@gmail.com - Ángela Carolina Castillo Rodríguez.
 * @version - 1.0.0
 * @since - 1.0.0
 */

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void givenApplicationDateWhitDay14AndTime10_WhenGetPrice_ThenReturnPriceIdOne() throws Exception {
    mockMvc.perform(get("/prices")
            .param("applicationDate", "2020-06-14T10:00:00")
            .param("productId", "35455")
            .param("brandId", "1"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
        .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1))
        .andExpect(MockMvcResultMatchers.jsonPath("$.priceId").value(1))
        .andExpect(MockMvcResultMatchers.jsonPath("$.finalPrice").value(35.50));
  }

  @Test
  void givenApplicationDateWhitDay14AndTime16_WhenGetPrice_ThenValidatePriorityAndReturnPriceIdTwo()
      throws Exception {
    mockMvc.perform(get("/prices")
            .param("applicationDate", "2020-06-14T16:00:00")
            .param("productId", "35455")
            .param("brandId", "1"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
        .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1))
        .andExpect(MockMvcResultMatchers.jsonPath("$.priceId").value(2))
        .andExpect(MockMvcResultMatchers.jsonPath("$.finalPrice").value(25.45));
  }

  @Test
  void givenApplicationDateWhitDay14AndTime21_WhenGetPrice_ThenReturnPriceIdOne() throws Exception {
    mockMvc.perform(get("/prices")
            .param("applicationDate", "2020-06-14T21:00:00")
            .param("productId", "35455")
            .param("brandId", "1"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
        .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1))
        .andExpect(MockMvcResultMatchers.jsonPath("$.priceId").value(1))
        .andExpect(MockMvcResultMatchers.jsonPath("$.finalPrice").value(35.50));
  }

  @Test
  void givenApplicationDateWhitDay15AndTime10_WhenGetPrice_ThenValidatePriorityAndReturnPriceIdThree()
      throws Exception {
    mockMvc.perform(get("/prices")
            .param("applicationDate", "2020-06-15T10:00:00")
            .param("productId", "35455")
            .param("brandId", "1"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
        .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1))
        .andExpect(MockMvcResultMatchers.jsonPath("$.priceId").value(3))
        .andExpect(MockMvcResultMatchers.jsonPath("$.finalPrice").value(30.50));
  }

  @Test
  void givenApplicationDateWhitDay16AndTime21_WhenGetPrice_ThenValidatePriorityAndReturnPriceIdFour()
      throws Exception {
    mockMvc.perform(get("/prices")
            .param("applicationDate", "2020-06-16T21:00:00")
            .param("productId", "35455")
            .param("brandId", "1"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
        .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1))
        .andExpect(MockMvcResultMatchers.jsonPath("$.priceId").value(4))
        .andExpect(MockMvcResultMatchers.jsonPath("$.finalPrice").value(38.95));
  }

}