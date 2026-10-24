/*
 * Copyright (c) 2026 Debajyoti Nath. Licensed under the MIT License; see LICENSE.
 */
package com.example.discoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Entry point for the Netflix Eureka discovery server. This standalone server
 * hosts the registry; it does not register itself as a client or fetch a
 * registry, as configured in {@code application.yml}.
 *
 * @author Debajyoti Nath (Technical Architect - Java Backend)
 */
@EnableEurekaServer
@SpringBootApplication
public class DiscoveryServerApplication {

    /**
     * Starts the Eureka discovery server.
     *
     * @param args command-line arguments passed to Spring Boot
     */
    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServerApplication.class, args);
    }
}
