/*
 * Copyright (c) 2026 Debajyoti Nath. All rights reserved.
 */
package com.example.quoteservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Entry point for the Eureka-registered quote service. The application
 * name and registry URL are configured in {@code application.yml}.
 *
 * @author Debajyoti Nath (Technical Architect - Java Backend)
 */
@EnableDiscoveryClient
@SpringBootApplication
public class QuoteServiceApplication {

    /**
     * Starts the quote service.
     *
     * @param args command-line arguments passed to Spring Boot
     */
    public static void main(String[] args) {
        SpringApplication.run(QuoteServiceApplication.class, args);
    }
}
