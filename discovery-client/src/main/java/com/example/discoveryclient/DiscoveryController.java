/*
 * Copyright (c) 2026 Debajyoti Nath. All rights reserved.
 */
package com.example.discoveryclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

/**
 * Exposes an endpoint that composes responses from Eureka-registered services.
 *
 * @author Debajyoti Nath (Technical Architect - Java Backend)
 */
@RestController
public class DiscoveryController {

    private final RestClient restClient;

    public DiscoveryController(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.build();
    }

    /**
     * Fetches a greeting and a quote using their Eureka service IDs.
     *
     * @return responses retrieved from the registered services
     */
    @GetMapping("/api/discovery/summary")
    public DiscoverySummary summary() {
        Greeting greeting = restClient.get()
                .uri("http://greeting-service/api/greeting")
                .retrieve()
                .body(Greeting.class);
        Quote quote = restClient.get()
                .uri("http://quote-service/api/quote")
                .retrieve()
                .body(Quote.class);
        return new DiscoverySummary(greeting, quote);
    }

    public record Greeting(String message) {
    }

    public record Quote(String message) {
    }

    public record DiscoverySummary(Greeting greeting, Quote quote) {
    }
}
