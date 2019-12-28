package com.marki.mipan.model;

public class Survey {
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

    public Long[] getQuestions() {
        return questions;
    }

    public void setQuestions(Long[] questions) {
        this.questions = questions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private Long created_date;
    private String creator_username;
    private String description;
    private Long end_date;
    private Long mip_coin;
    private Long[]  questions;
    private String title;
}
