# Spring Netflix Eureka Discovery Demo

A Spring Boot multi-module example of service registration, discovery, and
service-to-service REST calls using Netflix Eureka and Spring Cloud
LoadBalancer. The project contains a Eureka registry, two REST providers, and
a REST consumer that discovers both providers by application name.

See [ARCHITECTURE.md](ARCHITECTURE.md) for the component diagram, request flow,
configuration notes, and guidance for extending the example.

## Modules and endpoints

| Module | Eureka application name | Port | Endpoint / purpose |
| --- | --- | ---: | --- |
| `discovery-server` | `discovery-server` | 8761 | Eureka dashboard and registry at `/` and `/eureka/` |
| `greeting-service` | `greeting-service` | 8081 | `GET /api/greeting` |
| `quote-service` | `quote-service` | 8082 | `GET /api/quote` |
| `discovery-client` | `discovery-client` | 8083 | `GET /api/discovery/summary` |

The provider endpoints return JSON objects with a `message` field. The summary
endpoint returns both provider response objects:

```json
{
  "greeting": {
    "message": "Hello from a service registered with Netflix Eureka!"
  },
  "quote": {
    "message": "Great things are done by a series of small things brought together."
  }
}
```

## Requirements

- Java 21
- Maven 3.6.3 or newer

## Build

From the repository root, compile and test all modules:

```bash
mvn -B test
```

## Run locally

Run each command in a separate terminal from the repository root. Start the
registry first, then the providers, and finally the consumer:

```bash
mvn -pl discovery-server spring-boot:run
```

```bash
mvn -pl greeting-service spring-boot:run
```

```bash
mvn -pl quote-service spring-boot:run
```

```bash
mvn -pl discovery-client spring-boot:run
```

The Eureka dashboard is available at [http://localhost:8761](http://localhost:8761).
Once started, the greeting service, quote service, and discovery client appear
in the registry as `GREETING-SERVICE`, `QUOTE-SERVICE`, and `DISCOVERY-CLIENT`.

Call the provider endpoints directly:

```bash
curl http://localhost:8081/api/greeting
curl http://localhost:8082/api/quote
```

Call the consumer to verify service discovery and composition:

```bash
curl http://localhost:8083/api/discovery/summary
```

The consumer resolves `greeting-service` and `quote-service` through Eureka
and Spring Cloud LoadBalancer. It does not use the providers' fixed local
ports for downstream requests.

## License

This project is licensed under the MIT License. See [LICENSE](LICENSE) for
the full license text. Third-party libraries and tools are subject to their
respective licenses.
