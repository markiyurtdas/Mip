package com.marki.mipan.model;

import java.util.List;

public class Survey {

    private Long survey_id;
    private Long created_date;
    private String creator_username;
    private String description;
    private Long end_date;
    private Long mip_coin;
    private List<Question> questions;
    private String title;
    private List<List<String>> answers;

    public Long getSurvey_id() {
        return survey_id;
    }

    public void setSurvey_id(Long survey_id) {
        this.survey_id = survey_id;
    }

    public Long getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Long created_date) {
        this.created_date = created_date;
    }

    public String getCreator_username() {
        return creator_username;
    }

    public void setCreator_username(String creator_username) {
        this.creator_username = creator_username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Long end_date) {
        this.end_date = end_date;
    }

    public Long getMip_coin() {
        return mip_coin;
    }

    public void setMip_coin(Long mip_coin) {
        this.mip_coin = mip_coin;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<List<String>> getAnswers() {
        return answers;
    }

    public void setAnswers(List<List<String>> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "survey_id=" + survey_id +
                ", created_date=" + created_date +
                ", creator_username='" + creator_username + '\'' +
                ", description='" + description + '\'' +
                ", end_date=" + end_date +
                ", mip_coin=" + mip_coin +
                ", questions=" + questions +
                ", title='" + title + '\'' +
                ", answers=" + answers +
                '}';
    }
}

class Question {
    private List<String> check_values;
    private String description;

    public List<String> getCheckValues() {
        return check_values;
    }

    public void setCheckValues(List<String> check_values) {
        this.check_values = check_values;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Question{" +
                "checkValues=" + check_values +
                ", description='" + description + '\'' +
                '}';
    }
}
