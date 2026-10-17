package com.example.greetingservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/api/greeting")
    public Greeting greeting() {
        return new Greeting("Hello from a service registered with Netflix Eureka!");
    }

    public record Greeting(String message) {
    }
}
