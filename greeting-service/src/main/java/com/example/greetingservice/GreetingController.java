/*
 * Copyright (c) 2026 Debajyoti Nath. All rights reserved.
 */
package com.example.greetingservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Exposes the greeting endpoint provided by the greeting service.
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
     * Response containing a greeting message.
     *
     * @param message greeting text returned by the service
     */
    public record Greeting(String message) {
    }
}
