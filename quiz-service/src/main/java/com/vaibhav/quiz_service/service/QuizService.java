package com.vaibhav.quiz_service.service;


import com.vaibhav.quiz_service.dao.QuizDao;
import com.vaibhav.quiz_service.entity.Question;
import com.vaibhav.quiz_service.entity.QuestionWrapper;
import com.vaibhav.quiz_service.entity.Quiz;
import com.vaibhav.quiz_service.entity.Response;
import com.vaibhav.quiz_service.feign.QuizInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Integer> questions = quizInterface.getQuestionsForQuiz(category,numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Quiz Created", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
       Quiz quiz  = quizDao.findById(id).get();
       List<Integer> questions = quiz.getQuestionIds();

      ResponseEntity<List<QuestionWrapper> > question = quizInterface.getQuestionsFromId(questions);
      return question;

    }


    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        return quizInterface.getScore(responses);

    }
}
