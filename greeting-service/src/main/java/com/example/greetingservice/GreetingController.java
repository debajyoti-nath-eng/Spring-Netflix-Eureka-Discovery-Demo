/*
 * Copyright (c) 2026 Debajyoti Nath. Licensed under the MIT License; see LICENSE.
 */
package com.example.greetingservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Exposes the greeting endpoint provided by the greeting service.
 * This service is independently deployable and registers with Eureka under
 * the application name {@code greeting-service}.
 *
 * @author Debajyoti Nath (Technical Architect - Java Backend)
 */
@RestController
public class GreetingController {

    /**
     * Returns a greeting confirming that this service is available.
     *
     * @return the greeting response
     */
    @GetMapping("/api/greeting")
    public Greeting greeting() {
        return new Greeting("Hello from a service registered with Netflix Eureka!");
    }

    /**
     * Response body returned by {@code GET /api/greeting}.
     *
     * @param message greeting text returned by the service
     */
    public record Greeting(String message) {
    }
}
