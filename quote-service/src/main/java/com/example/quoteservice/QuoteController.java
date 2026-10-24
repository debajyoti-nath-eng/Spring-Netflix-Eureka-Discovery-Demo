/*
 * Copyright (c) 2026 Debajyoti Nath. All rights reserved.
 */
package com.example.quoteservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Exposes the quote endpoint provided by the quote service.
 *
 * @author Debajyoti Nath (Technical Architect - Java Backend)
 */
@RestController
public class QuoteController {

    /**
     * Returns a quote confirming that this service is available.
     *
     * @return the quote response
     */
    @GetMapping("/api/quote")
    public Quote quote() {
        return new Quote("Great things are done by a series of small things brought together.");
    }

    /**
     * Response containing a quote.
     *
     * @param message quote text returned by the service
     */
    public record Quote(String message) {
    }
}
