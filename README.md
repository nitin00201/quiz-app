# Quiz App

## Overview
This is a Spring Boot-based Quiz Application providing RESTful API endpoints for a quiz management system.

## Assumptions
- Single user scenario
- Questions are pre-loaded
- Simple scoring mechanism
- In-memory H2 database

## Prerequisites
- Java 17 or higher
- Maven
- Git

## Technology Stack
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Lombok


## API Endpoints
1. Start Quiz: POST /api/quiz/start?userId=1
2. Get Random Question: GET /api/quiz/question
3. Submit Answer: POST /api/quiz/submit
4. Get Session Details: GET /api/quiz/session/{sessionId}

## Project Setup

### Clone the Repository
```bash
 git clone https://github.com/nitin00201/quiz-app.git
 cd quiz-app
