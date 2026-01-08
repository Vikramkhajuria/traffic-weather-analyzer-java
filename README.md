# Traffic & Weather Bottleneck Analyzer – Class Guide

Java project that started as a console-based risk analyzer and has been incrementally evolved into a Spring Boot REST API.

The goal of this project is not to build a complex system, but to learn how real software systems are structured: clean domain logic, separation of concerns, and exposing functionality through a backend API.

Project Evolution

Phase 0 – Console Application (OOP Foundations)

Menu-driven CLI

Multiple locations

Weather + traffic simulation

Risk classification logic

Interfaces and polymorphism

Phase 1 - Backend API (Current)

Existing domain logic wrapped with Spring Boot

REST endpoint exposing risk calculation as JSON

Embedded Tomcat running on port 8080

Java 17 + Gradle (industry-aligned setup)

Future versions will add proper dependency injection, configuration-based data sources, and a frontend dashboard.


Architecture Overview

The project is intentionally split into clear layers:

app      → CLI entry point (legacy, still kept)
domain   → Core business logic (risk calculation)
data     → Data providers (fake / random)
model    → Pure data objects
web      → Spring Boot REST API (OH DAMN)



## Packages and Classes

app

Main.java
Original CLI entry point. Builds a DataService, TrafficAnalyzer, and AllLocationAnalyzer, presents a menu, and prints results to the console.
This remains for local testing and learning.

domain

TrafficAnalyzer.java
Core rule engine. Determines RiskLevel based on weather and congestion:

High congestion + snow → HIGH

Medium congestion → MEDIUM

Otherwise → LOW

AllLocationAnalyzer.java
Batch runner. Iterates over all locations, fetches data via DataService, evaluates risk using TrafficAnalyzer, and produces per-location summaries.

RiskLevel.java
Enum representing LOW, MEDIUM, and HIGH.
data

DataService.java
Interface defining the data contract:

available locations

weather for a location

traffic for a location

FakeDataService.java
Deterministic, in-memory data. Useful for demos and predictable output.

RandomDataService.java
Generates random weather and congestion values on each request.
model

Location.java
Value object representing a location.

WeatherInfo.java
Temperature and condition (e.g. Snow, Cloudy).

TrafficInfo.java
Traffic congestion level.

## Web 

TrafficWeatherAnalyzerApplication.java
Spring Boot application entry point.

RiskController.java
REST controller exposing the domain logic via HTTP.

RiskResponse.java
DTO returned as JSON to clients.

## How Data Flows
Console (legacy)

CLI selects a location

DataService provides weather + traffic

TrafficAnalyzer evaluates risk

Result printed to console

REST API (current)

HTTP request hits /api/risk

Controller delegates to existing domain logic

Risk result returned as JSON

The same domain logic is used in both cases.

## Why This Project Exists

This project is primarily a learning exercise focused on:

Object-Oriented Design

Separation of concerns

Interfaces and polymorphism

Transitioning from a console app to a backend service

Understanding how domain logic can be reused across different entry points

The code is intentionally simple and incremental to ensure the fundamentals are understood before adding complexity.

## Next Steps (Planned)

Introduce Spring Dependency Injection (@Service, @Configuration)

Switch data source via configuration instead of code

Add /api/locations endpoint

Improve error handling (HTTP status codes)

Frontend dashboard

Cloud deployment (Azure)

## Tech Stack

Java 17

Gradle

Spring Boot

REST / JSON

Git & GitHub
