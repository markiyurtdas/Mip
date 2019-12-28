package com.marki.mipan.model;

public class JobAds {
    @Override
    public String toString() {
        return "JobAds{" +
                "job_id=" + job_id +
                ", company='" + company + '\'' +
                ", company_mail='" + company_mail + '\'' +
                ", created_date=" + created_date +
                ", description='" + description + '\'' +
                ", end_date=" + end_date +
                ", photo_url='" + photo_url + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                '}';
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

    public Long getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Long created_date) {
        this.created_date = created_date;
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

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private Long job_id;

    public Long getJob_id() {
        return job_id;
    }

    public void setJob_id(Long job_id) {
        this.job_id = job_id;
    }

    private String company;
    private String company_mail;
    private Long created_date;
    private String description;
    private Long end_date;
    private String photo_url;
    private String title;
    private String type;
}
