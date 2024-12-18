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


## Project Setup

### Clone the Repository
```bash
 git clone https://github.com/nitin00201/quiz-app.git
 cd quiz-app
```
API Endpoints
-------------

### 1\. Start New Quiz Session

*   Endpoint: ```POST /api/quiz/start```

*   Query Parameter: userId(Long)

*   Response: QuizSession object

*   Description: Initiates a new quiz session for a user




### 2\. Get Random Question

*   Endpoint: ```GET /api/quiz/question ```

*   Response: Question object with multiple-choice options

*   Description: Retrieves a random question from the database




### 3\. Submit Answer

*   Endpoint: ```POST /api/quiz/submit```

*   **Query Parameters:**

    *   sessionId(Long)

    *   selectedAnswer(String)

    *   questionId(Long)

*   Response: Updated QuizSession object

*   Description: Submits user's answer and updates quiz session statistics




### 4\. Get Quiz Session Details

*   Endpoint: ```GET /api/quiz/session/{sessionId}```

*   Path Parameter: sessionId(Long)

*   Response: QuizSession object

*   Description: Retrieves detailed statistics of a quiz session




Database Configuration
----------------------

*   **Type:** H2 In-Memory Database

*   **Console Access:**
```bash
http://localhost:8080/h2-console
```

*   **JDBC URL:** ```jdbc:h2:mem:quizdb```

*   **Username:** ``sa``

*   Password:
