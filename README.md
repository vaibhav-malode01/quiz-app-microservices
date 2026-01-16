# Quiz Application – Microservices Architecture

This project is a microservices-based Quiz Application built using Spring Boot and Spring Cloud.

## Microservices Included
- Service Registry (Eureka Server)
- API Gateway (Spring Cloud Gateway)
- Quiz Service
- Question Service

## Architecture Overview
- Microservices architecture
- Service discovery using Eureka
- Centralized routing using API Gateway
- Inter-service communication using OpenFeign
- Client-side load balancing
- Separate database per service

## Tech Stack
- Java 17
- Spring Boot
- Spring Cloud (Eureka, Gateway, OpenFeign)
- PostgreSQL
- Maven

## How to Run the Project
1. Start **Service Registry**
2. Start **Question Service**
3. Start **Quiz Service**
4. Start **API Gateway**

## Notes
- This project was first built as a monolithic application and later refactored into microservices to demonstrate architectural evolution.
