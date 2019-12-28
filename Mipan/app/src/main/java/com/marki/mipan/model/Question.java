package com.marki.mipan.model;

import java.util.List;

public class Question {
    private Integer q_id;
    private String q_type;
    private String title;
    private String description;
    private boolean is_required;
    private List<String> check_values;
    private long create_date;
    private long end_date;

    public Question() {
    }

    @Override
    public String toString() {
        return "Question{" +
                "q_id=" + q_id +
                ", q_type='" + q_type + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", is_required=" + is_required +
                ", check_values=" + check_values +
                ", create_date=" + create_date +
                ", end_date=" + end_date +
                '}';
    }

    public String getQ_type() {
        return q_type;
    }

    public void setQ_type(String q_type) {
        this.q_type = q_type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIs_required() {
        return is_required;
    }

    public void setIs_required(boolean is_required) {
        this.is_required = is_required;
    }

    public List<String> getCheck_values() {
        return check_values;
    }

    public void setCheck_values(List<String> check_values) {
        this.check_values = check_values;
    }

    public long getCreate_date() {
        return create_date;
    }

    public void setCreate_date(long create_date) {
        this.create_date = create_date;
    }

    public long getEnd_date() {
        return end_date;
    }

    public void setEnd_date(long end_date) {
        this.end_date = end_date;
    }

    public Integer getQ_id() {
        return q_id;
    }

    public void setQ_id(Integer q_id) {
        this.q_id = q_id;
    }
}
