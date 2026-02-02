**Traffic & Weather Bottleneck Analyzer (Backend)**

A containerized Spring Boot backend that analyzes traffic congestion risk based on location data, weather conditions, and traffic signals.
Built to practice real-world backend engineering workflows, not just coursework.

**What this project is**

This project simulates how a backend service:
- exposes REST APIs
- persists domain data in a relational database
- applies business logic to compute risk levels
- runs consistently across environments using Docker
The goal was to move beyond “works on my machine” and build something that resembles how production backends are actually developed and run.

**Core Concepts Practiced**

- REST API design with Spring Boot
- Layered backend architecture (Controller → Service → Repository)
- JPA / Hibernate with PostgreSQL
- Domain-driven risk evaluation logic
- Database schema management
- Environment-agnostic execution using Docker & Docker Compose

**Architecture Overview**

Client (Browser / API tool)
        ↓
Spring Boot REST API
        ↓
Service Layer (Risk Evaluation)
        ↓
JPA / Hibernate
        ↓
PostgreSQL Database

All services run inside Docker containers, ensuring consistent behavior across machines.


**Tech Stack**

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

**Features Implemented**
- Persisted Location entities stored in PostgreSQL
- Automatic database schema creation via Hibernate
- Risk calculation based on:
    - Traffic congestion level
    - Weather conditions
- REST endpoints for:
    - Risk analysis by location
    - Location lookup
- Application runs fully containerized (API + DB)


**Why Docker is used here**

Docker ensures:
- consistent Java version (Java 17)
- consistent database setup
- no local environment dependency issues
- easy onboarding for anyone cloning the repo
This mirrors how backend services are typically run in professional environments.

**What I learned**

- How backend services actually connect to databases in real setups
- Why environment mismatches cause production bugs
- How Docker removes “machine-specific” problems
- How to debug backend + database issues across containers
- How JPA behaves during schema generation and startup

**Next Improvements (planned)**

- Seed database via startup scripts
- Replace mock data with fully DB-driven flows
- Add request validation & error handling
- Introduce API documentation via OpenAPI
- Add basic tests for service layer
- Prepare for cloud deployment

**Author**

BSc Software Development (started Sep 2025)
Focused on backend engineering, systems thinking, and real-world development practices.

**Final note**

This project is intentionally backend-focused.
No UI, no distractions — just core engineering fundamentals done properly.
