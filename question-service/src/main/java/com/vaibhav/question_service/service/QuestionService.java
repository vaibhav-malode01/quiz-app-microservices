package com.vaibhav.question_service.service;


import com.vaibhav.question_service.dao.QuestionDao;
import com.vaibhav.question_service.entity.Question;
import com.vaibhav.question_service.entity.QuestionWrapper;
import com.vaibhav.question_service.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try{
            return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        try{
            return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionDao.save(question);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz
            (String categoryName,@RequestParam Integer numQ) {
        List<Integer> questions = questionDao.findRandomQuestionsByCategory(categoryName,numQ);
        return new ResponseEntity<>(questions,HttpStatus.OK);
    }


    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds) {
        List<QuestionWrapper> wrappers    = new ArrayList<>();

        List<Question> questions = new ArrayList<>();

        for(Integer id: questionIds) {
            questions.add(questionDao.findById(id).get());
        }

        for(Question q : questions){
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            wrappers.add(qw);
        }

        return new ResponseEntity<>(wrappers, HttpStatus.OK);


    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {
        int count = 0;

        for(Response response : responses) {
            Optional<Question> question = questionDao.findById(response.getId());
            if(response.getResponse().equals(question.get().getRightAnswer())){
                count++;
            }
        }

        return new ResponseEntity<>(count,HttpStatus.OK);

    }
}
