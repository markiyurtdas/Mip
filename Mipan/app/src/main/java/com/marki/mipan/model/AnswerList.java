package com.marki.mipan.model;

import java.util.List;

public class AnswerList {
    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Long getSend_date() {
        return send_date;
    }

    public void setSend_date(Long send_date) {
        this.send_date = send_date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private List<Answer> answers;
    private Long send_date;
    private String username;

    @Override
    public String toString() {
        return "AnswerList{" +
                "answers=" + answers +
                ", send_date=" + send_date +
                ", username='" + username + '\'' +
                '}';
    }
}
class Answer{
    @Override
    public String toString() {
        return "Answer{" +
                "answer='" + answer + '\'' +
                ", answer_type='" + answer_type + '\'' +
                '}';
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer_type() {
        return answer_type;
    }

    public void setAnswer_type(String answer_type) {
        this.answer_type = answer_type;
    }

    private String answer;
    private String answer_type;
}
