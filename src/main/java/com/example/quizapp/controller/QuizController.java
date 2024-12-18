package com.example.quizapp.controller;

import com.example.quizapp.model.Question;
import com.example.quizapp.model.QuizSession;
import com.example.quizapp.repository.QuestionRepository;
import com.example.quizapp.repository.QuizSessionRepository;
import com.example.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizSessionRepository quizSessionRepository;

    @PostMapping("/start")
    public ResponseEntity<QuizSession> startQuiz(@RequestParam Long userId) {
        return ResponseEntity.ok(quizService.startNewQuizSession(userId));
    }

    @GetMapping("/question")
    public ResponseEntity<Question> getRandomQuestion() {
        return ResponseEntity.ok(quizService.getRandomQuestion());
    }

    @PostMapping("/submit")
    public ResponseEntity<QuizSession> submitAnswer(
            @RequestParam Long sessionId,
            @RequestParam String selectedAnswer,
            @RequestParam Long questionId
    ) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found"));

        return ResponseEntity.ok(quizService.submitAnswer(sessionId, selectedAnswer, question));
    }

    @GetMapping("/session/{sessionId}")
    public ResponseEntity<QuizSession> getSessionDetails(@PathVariable Long sessionId) {
        return ResponseEntity.ok(quizSessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found")));
    }
}