/*
 * Copyright (c) 2026 Debajyoti Nath. All rights reserved.
 */
package com.example.discoveryclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

/**
 * Entry point for a Eureka-registered service that consumes other services.
 *
 * @author Debajyoti Nath (Technical Architect - Java Backend)
 */
@EnableDiscoveryClient
@SpringBootApplication
public class DiscoveryClientApplication {

    /**
     * Starts the discovery client application.
     *
     * @param args command-line arguments passed to Spring Boot
     */
    public static void main(String[] args) {
        SpringApplication.run(DiscoveryClientApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestClient.Builder loadBalancedRestClientBuilder() {
        return RestClient.builder();
    }
}
