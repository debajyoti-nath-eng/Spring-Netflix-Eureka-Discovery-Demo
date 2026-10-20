# Spring Netflix Eureka Discovery Demo

A small Spring Boot multi-module project with a Netflix Eureka discovery server and a greeting service that registers itself with the server.

## Requirements

- Java 21
- Maven 3.6.3 or newer

## Run

Start the Eureka server in one terminal:

```bash
mvn -pl discovery-server spring-boot:run
```

Start the greeting service in another terminal:

```bash
mvn -pl greeting-service spring-boot:run
```

The Eureka dashboard is available at [http://localhost:8761](http://localhost:8761). After the greeting service starts, it appears in the registry as `GREETING-SERVICE`.

Call the greeting service at [http://localhost:8081/api/greeting](http://localhost:8081/api/greeting).

## License

Copyright © 2026 Debajyoti Nath (@debajyoti-nath-eng). All rights reserved.
You may access, download, clone, and view this repository for personal
reference only. You may not modify, reuse, distribute, publish, or commercially
use its contents without prior written permission. See [LICENSE](LICENSE) for
the full terms.

This license does not control GitHub repository permissions. Repository access
settings and branch rules must be configured separately to control who can
create branches or push changes.
