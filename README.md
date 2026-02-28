# Hotel Demo

> Sample Spring Boot application used for learning and experimentation. Includes REST endpoints, a simple Thymeleaf UI, and database scripts for H2 and PostgreSQL.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Requirements](#requirements)
- [Getting Started](#getting-started)
  - [Installing](#installing)
  - [Running](#running)
- [Configuration](#configuration)
- [Development](#development)
- [Testing](#testing)
- [Contributing](#contributing)
- [Authors](#authors)
- [License](#license)

## Overview

This repository contains a simple hotel reservation service built with Spring Boot. It was created as part of tutorials and personal learning projects, demonstrating how to expose REST APIs, use Spring Data JPA, and render server‑side HTML with Thymeleaf.

## Features

- CRUD REST API for rooms and reservations (`/api/*`).
- Thymeleaf‑based web pages for occupancy and room lists.
- Support for H2 (in-memory) and PostgreSQL databases with sample schema and data.
- Maven build and Spring Boot actuator enabled.

## Requirements

- Java Development Kit (JDK) 17 or later
- Apache Maven 3.6 or later

## Getting Started

### Installing

```bash
git clone https://github.com/gutors/hotel.git
cd hotel
mvn clean package
```

### Running

#### In-memory (H2)

The application will start with H2 by default. Launch with:

```bash
mvn spring-boot:run
```

Once started, access the REST endpoints at `http://localhost:8080/api/` and the UI pages at `http://localhost:8080/`.

#### PostgreSQL

A `bin/postgresql` folder contains `schema.sql` and `data.sql` plus helper scripts (`start_postgres.sh`/`stop_postgres.sh`).

Update `src/main/resources/application.properties` or set `SPRING_DATASOURCE_URL`/`USER`/`PASSWORD` appropriately before running.

## Configuration

Properties are managed via `application.properties`. Common settings:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.jpa.hibernate.ddl-auto=update
```

Override with environment variables or command‑line arguments.

## Development

Modify source under `src/main/java/com/gutors/hotel`. The project uses Lombok, so ensure annotation processing is enabled in your IDE. Build changes with `mvn package` and restart the application with `mvn spring-boot:run`.

## Testing

Unit tests live in `src/test/java`. Run them with:

```bash
mvn test
```

## Contributing

This is a personal learning repository. Feel free to fork or submit suggestions via pull request, but there is no formal contribution process.

## Authors

* **Gustavo Schmid de Jesus** – <https://github.com/gutors>

## License

No license is specified for this project. Add a `LICENSE` file if you plan to make the code public or re‑use it.
