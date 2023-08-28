///**
// * Copyright 2023, Neoris. All rights reserved Date: 28/08/23
// */
//package com.innoqa.pricecalculation.application.security;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
///**
// * @author angiekroll@gmail.com - Ángela Carolina Castillo Rodríguez.
// * @version - 1.0.0
// * @since - 1.0.0
// */
//
//@Configuration
//public class SecurityConfig {
//
//  // Configuración básica de seguridad, igual si quito esta clase debe funcionar la seguridad basica, esta clase es para configuraciones personalizadas
//  @Bean
//  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    http
//        .authorizeHttpRequests((authz) -> authz
//            .anyRequest().authenticated()
//        )
//        .httpBasic(withDefaults());
//    return http.build();
//  }
//
////  para excluir los enpoints de la seguridad, puede ser un login
//  @Bean
//  public WebSecurityCustomizer webSecurityCustomizer() {
//    return (web) -> web.ignoring().requestMatchers(new AntPathRequestMatcher("/prices"));
//  }
//
//
//}