package com.vaibhav.quiz_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
    private String difficultylevel;
    private String category;

    public Question() {}

    public Integer getId() {
        return id;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public String getDifficultylevel() {
        return difficultylevel;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Question{id=" + id + ", questionTitle='" + questionTitle + "'}";
    }
}
