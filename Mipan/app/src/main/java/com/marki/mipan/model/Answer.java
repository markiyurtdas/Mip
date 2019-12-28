package com.marki.mipan.model;

import java.util.List;

public class Answer {
    private Integer answer_id;
    private Integer q_id;
    private String answer;
    private String answer_type;

    public Answer() {
    }

    public Answer(Integer answer_id, Integer q_id, String answer, String answer_type) {
        this.answer_id = answer_id;
        this.q_id = q_id;
        this.answer = answer;
        this.answer_type = answer_type;
    }

    public Integer getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(Integer answer_id) {
        this.answer_id = answer_id;
    }

    public Integer getQ_id() {
        return q_id;
    }

    public void setQ_id(Integer q_id) {
        this.q_id = q_id;
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

    @Override
    public String toString() {
        return "Answer{" +
                "answer_id=" + answer_id +
                ", q_id=" + q_id +
                ", answer='" + answer + '\'' +
                ", answer_type='" + answer_type + '\'' +
                '}';
    }
}
