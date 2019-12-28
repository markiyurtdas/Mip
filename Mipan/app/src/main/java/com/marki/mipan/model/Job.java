package com.marki.mipan.model;

import java.util.List;

public class Job {

    private Integer job_id;
    private String type;
    private String title;
    private String description;
    private String photo;
    private String company;
    private String company_mail;
    private Long creator_username;
    private long created_date;
    private long end_date;

    public Job() {
    }

    @Override
    public String toString() {
        return "Job{" +
                "job_id=" + job_id +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", photo='" + photo + '\'' +
                ", company='" + company + '\'' +
                ", company_mail='" + company_mail + '\'' +
                ", creator_username=" + creator_username +
                ", created_date=" + created_date +
                ", end_date=" + end_date +
                '}';
    }

    public Integer getJob_id() {
        return job_id;
    }

    public void setJob_id(Integer job_id) {
        this.job_id = job_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany_mail() {
        return company_mail;
    }

    public void setCompany_mail(String company_mail) {
        this.company_mail = company_mail;
    }

    public Long getCreator_username() {
        return creator_username;
    }

    public void setCreator_username(Long creator_username) {
        this.creator_username = creator_username;
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
}
