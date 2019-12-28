package com.marki.mipan.model;

import java.util.List;

public class Survey {
    private Long survey_id;
    private Long creator_username;
    private String title;
    private String description;
    private long created_date;
    private long end_date;
    private List<String> answers;

    public Survey(Long survey_id, Long creator_username, String title, String description, long created_date, long end_date, List<String> answers) {
        this.survey_id = survey_id;
        this.creator_username = creator_username;
        this.title = title;
        this.description = description;
        this.created_date = created_date;
        this.end_date = end_date;
        this.answers = answers;
    }

    public Long getSurvey_id() {
        return survey_id;
    }

    public void setSurvey_id(Long survey_id) {
        this.survey_id = survey_id;
    }

    public Long getCreator_username() {
        return creator_username;
    }

    public void setCreator_username(Long creator_username) {
        this.creator_username = creator_username;
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

    public long getCreated_date() {
        return created_date;
    }

    public void setCreated_date(long created_date) {
        this.created_date = created_date;
    }

    public long getEnd_date() {
        return end_date;
    }

    public void setEnd_date(long end_date) {
        this.end_date = end_date;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public Survey() {
    }

    @Override
    public String toString() {
        return "Survey{" +
                "survey_id=" + survey_id +
                ", creator_username=" + creator_username +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", created_date=" + created_date +
                ", end_date=" + end_date +
                ", answers=" + answers +
                '}';
    }
}
