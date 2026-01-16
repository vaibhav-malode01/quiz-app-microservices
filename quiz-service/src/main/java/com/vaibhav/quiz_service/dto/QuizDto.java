package com.vaibhav.quiz_service.dto;

public class QuizDto {

    private String category;
    private int numQ;
    private String title;

    public QuizDto() {}

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNumQ() {
        return numQ;
    }

    public void setNumQ(int numQ) {
        this.numQ = numQ;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
