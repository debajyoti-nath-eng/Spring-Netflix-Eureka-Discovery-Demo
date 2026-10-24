# Spring Netflix Eureka Discovery Demo

A Spring Boot multi-module project demonstrating Netflix Eureka service registration and service-to-service discovery.

## Requirements

- Java 21
- Maven 3.6.3 or newer

## Run

Start the Eureka server in one terminal:

```bash
mvn -pl discovery-server spring-boot:run
```

Start the greeting and quote services in separate terminals:

```bash
mvn -pl greeting-service spring-boot:run
mvn -pl quote-service spring-boot:run
```

Start the discovery client in another terminal:

```bash
mvn -pl discovery-client spring-boot:run
```

The Eureka dashboard is available at [http://localhost:8761](http://localhost:8761). The greeting service, quote service, and discovery client register as `GREETING-SERVICE`, `QUOTE-SERVICE`, and `DISCOVERY-CLIENT`.

The provider endpoints are [http://localhost:8081/api/greeting](http://localhost:8081/api/greeting) and [http://localhost:8082/api/quote](http://localhost:8082/api/quote). The discovery client exposes [http://localhost:8083/api/discovery/summary](http://localhost:8083/api/discovery/summary), which resolves both providers by their Eureka service IDs through Spring Cloud LoadBalancer.

## License

Copyright © 2026 Debajyoti Nath (@debajyoti-nath-eng). All rights reserved.
You may access, download, clone, and view this repository for personal
reference only. You may not modify, reuse, distribute, publish, or commercially
use its contents without prior written permission. See [LICENSE](LICENSE) for
the full terms.

This license does not control GitHub repository permissions. Repository access
settings and branch rules must be configured separately to control who can
create branches or push changes.
