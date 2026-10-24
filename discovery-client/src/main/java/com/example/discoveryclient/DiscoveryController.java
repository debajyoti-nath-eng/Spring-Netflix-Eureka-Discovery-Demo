/*
 * Copyright (c) 2026 Debajyoti Nath. All rights reserved.
 */
package com.example.discoveryclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

/**
 * Exposes an endpoint that composes responses from Eureka-registered services.
 * Provider addresses use Eureka application IDs so instances can move or
 * scale without changing this consumer's configuration.
 *
 * @author Debajyoti Nath (Technical Architect - Java Backend)
 */
@RestController
public class DiscoveryController {

    private final RestClient restClient;

    /**
     * Creates the controller with the load-balanced client builder.
     *
     * @param restClientBuilder builder configured to resolve Eureka service IDs
     */
    public DiscoveryController(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.build();
    }

    /**
     * Fetches a greeting and a quote using their Eureka service IDs.
     * Downstream HTTP or discovery failures are propagated by {@link RestClient};
     * this endpoint does not return a partial or fallback response.
     *
     * @return greeting and quote responses retrieved from the registered services
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

    /**
     * Greeting response received from the greeting service.
     *
     * @param message greeting text returned by the provider
     */
    public record Greeting(String message) {
    }

    /**
     * Quote response received from the quote service.
     *
     * @param message quote text returned by the provider
     */
    public record Quote(String message) {
    }

    /**
     * Combined response from both downstream services.
     *
     * @param greeting response from {@code greeting-service}
     * @param quote response from {@code quote-service}
     */
    public record DiscoverySummary(Greeting greeting, Quote quote) {
    }
}
