package com.example.quizapp.service;

import com.example.quizapp.model.Question;
import com.example.quizapp.model.QuizSession;
import com.example.quizapp.repository.QuestionRepository;
import com.example.quizapp.repository.QuizSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuizSessionRepository quizSessionRepository;

    public QuizSession startNewQuizSession(Long userId) {
        QuizSession session = new QuizSession();
        session.setUserId(1L);
        session.setTotalQuestions(0);
        session.setCorrectAnswers(0);
        session.setIncorrectAnswers(0);
        return quizSessionRepository.save(session);
    }

    public Question getRandomQuestion() {
        Pageable pageable = PageRequest.of(0, 1);
        List<Question> questions = questionRepository.findRandomQuestions(pageable);
        return questions.isEmpty() ? null : questions.get(0);
    }

    public QuizSession submitAnswer(Long sessionId, String selectedAnswer, Question question) {
        QuizSession session = quizSessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));

        session.setTotalQuestions(session.getTotalQuestions() + 1);

        if (selectedAnswer.equals(question.getCorrectAnswer())) {
            session.setCorrectAnswers(session.getCorrectAnswers() + 1);
        } else {
            session.setIncorrectAnswers(session.getIncorrectAnswers() + 1);
        }

        return quizSessionRepository.save(session);
    }
}