# Quiz App API

## Assumptions
- Single user scenario
- Questions are pre-loaded
- Simple scoring mechanism
- In-memory H2 database

## API Endpoints
1. Start Quiz: POST /api/quiz/start?userId=1
2. Get Random Question: GET /api/quiz/question
3. Submit Answer: POST /api/quiz/submit
4. Get Session Details: GET /api/quiz/session/{sessionId}