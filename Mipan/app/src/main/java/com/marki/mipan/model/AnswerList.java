package com.marki.mipan.model;

import java.util.List;

public class AnswerList {

    private Long answer_list_id;
    private Long survey_id;
    private String username;
    private long send_date;
    private List<String> answers;

    public AnswerList() {
    }

    @Override
    public String toString() {
        return "AnswerList{" +
                "answer_list_id=" + answer_list_id +
                ", survey_id=" + survey_id +
                ", username='" + username + '\'' +
                ", send_date=" + send_date +
                ", answers=" + answers +
                '}';
    }

    public Long getAnswer_list_id() {
        return answer_list_id;
    }

    public void setAnswer_list_id(Long answer_list_id) {
        this.answer_list_id = answer_list_id;
    }

    public Long getSurvey_id() {
        return survey_id;
    }

    public void setSurvey_id(Long survey_id) {
        this.survey_id = survey_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getSend_date() {
        return send_date;
    }

    public void setSend_date(long send_date) {
        this.send_date = send_date;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
}
