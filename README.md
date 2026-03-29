# Traffic & Weather Bottleneck Analyzer (Backend)

A containerized Spring Boot backend that analyzes traffic congestion risk based on location data, weather conditions, and traffic signals.
Built to practice real-world backend engineering workflows, not just coursework.

## What this project is

This project simulates how a backend service:
- exposes REST APIs
- persists domain data in a relational database
- applies business logic to compute risk levels
- runs consistently across environments using Docker

The goal was to move beyond "works on my machine" and build something that resembles how production backends are actually developed and run.

## Architecture Overview

```
Client (Browser / API tool)
        ↓
Spring Boot REST API
        ↓
Service Layer (Risk Evaluation)
        ↓
JPA / Hibernate
        ↓
PostgreSQL Database
```

All services run inside Docker containers, ensuring consistent behavior across machines.

## Tech Stack

**Backend**
- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Hibernate

**Database**
- PostgreSQL

**Infrastructure**
- Docker
- Docker Compose
- Gradle

## Features Implemented

- Location entities persisted in PostgreSQL, seeded automatically on startup
- Risk calculation based on traffic congestion level and weather conditions
- Scored risk evaluation with detailed reasoning per location
- REST endpoints:
  - `GET /api/v1/locations` — list all locations
  - `GET /api/v1/risk/{location}` — get risk analysis for a location
- Structured error responses with HTTP status codes
- API documentation via OpenAPI / Swagger UI (`/swagger-ui.html`)
- Application runs fully containerized (API + DB)

## Core Concepts Practiced

- REST API design with Spring Boot
- Layered backend architecture (Controller → Service → Repository)
- JPA / Hibernate with PostgreSQL
- Domain-driven risk evaluation logic
- Database schema management
- Environment-agnostic execution using Docker & Docker Compose

## Why Docker is used here

Docker ensures:
- consistent Java version (Java 17)
- consistent database setup
- no local environment dependency issues
- easy onboarding for anyone cloning the repo

This mirrors how backend services are typically run in professional environments.

## Running the project

```bash
docker compose up --build
```

The API will be available at `http://localhost:8080`.

## What I learned

- How backend services actually connect to databases in real setups
- Why environment mismatches cause production bugs
- How Docker removes "machine-specific" problems
- How to debug backend and database issues across containers
- How JPA behaves during schema generation and startup

## Next Improvements (planned)

- Replace mock data with fully DB-driven weather and traffic flows
- Add basic tests for service layer
- Prepare for cloud deployment

## Author

BSc Software Development (started Sep 2025)
Focused on backend engineering, systems thinking, and real-world development practices.

---

This project is intentionally backend-focused.
No UI, no distractions — just core engineering fundamentals done properly.
