package com.vaibhav.question_service.controller;




import com.vaibhav.question_service.dao.QuestionDao;
import com.vaibhav.question_service.entity.Question;
import com.vaibhav.question_service.entity.QuestionWrapper;
import com.vaibhav.question_service.entity.Response;
import com.vaibhav.question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    QuestionDao questionDao;

    @Autowired
    Environment environment;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getALlQuestions() {

        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category) {
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);

    }

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName,@RequestParam Integer numQ) {
        return questionService.getQuestionsForQuiz(categoryName,numQ);

    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>>  getQuestionsFromId(@RequestBody List<Integer> questionIds) {
        System.out.println(environment.getProperty("local.server.port"));
        return questionService.getQuestionsFromId(questionIds);


    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses) {
        return questionService.getScore(responses);
    }


    // generate
    // genQuestions(id)
    //getScore(response);




}
