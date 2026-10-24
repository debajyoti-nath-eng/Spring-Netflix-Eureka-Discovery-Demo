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
 * The load-balanced {@link RestClient.Builder} interprets a service ID in a
 * request URL as a Eureka lookup rather than a fixed hostname.
 *
 * @author Debajyoti Nath (Technical Architect - Java Backend)
 */
@EnableDiscoveryClient
@SpringBootApplication
public class DiscoveryClientApplication {

    /**
     * Starts the discovery client application, which registers with Eureka
     * and uses its registry to locate downstream services.
     *
     * @param args command-line arguments passed to Spring Boot
     */
    public static void main(String[] args) {
        SpringApplication.run(DiscoveryClientApplication.class, args);
    }

    /**
     * Creates the {@link RestClient.Builder} used for calls addressed by
     * Eureka service ID.
     *
     * @return a builder configured for Spring Cloud LoadBalancer
     */
    @Bean
    @LoadBalanced
    RestClient.Builder loadBalancedRestClientBuilder() {
        return RestClient.builder();
    }
}
