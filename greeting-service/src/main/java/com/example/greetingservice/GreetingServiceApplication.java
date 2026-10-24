/*
 * Copyright (c) 2026 Debajyoti Nath. Licensed under the MIT License; see LICENSE.
 */
package com.example.greetingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Entry point for the Eureka-registered greeting service.
 *
 * @author Debajyoti Nath (Technical Architect - Java Backend)
 */
@EnableDiscoveryClient
@SpringBootApplication
public class GreetingServiceApplication {

    /**
     * Starts the greeting service.
     *
     * @param args command-line arguments passed to Spring Boot
     */
    public static void main(String[] args) {
        SpringApplication.run(GreetingServiceApplication.class, args);
    }
}
