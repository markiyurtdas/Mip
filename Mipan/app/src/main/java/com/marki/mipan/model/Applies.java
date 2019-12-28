package com.marki.mipan.model;

public class Applies {
    @Override
    public String toString() {
        return "Applies{" +
                "apply_id=" + apply_id +
                ", description='" + description + '\'' +
                ", end_date='" + end_date + '\'' +
                ", file='" + file + '\'' +
                ", job_id=" + job_id +
                ", send_date=" + send_date +
                ", username='" + username + '\'' +
                '}';
    }

    public Long getApply_id() {
        return apply_id;
    }

    public void setApply_id(Long apply_id) {
        this.apply_id = apply_id;
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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Long getJob_id() {
        return job_id;
    }

    public void setJob_id(Long job_id) {
        this.job_id = job_id;
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

    private Long apply_id;
    private String description;
    private Long end_date;
    private String file;
    private Long job_id;
    private Long send_date;
    private String username;
}
