package com.marki.mipan.model;

public class Applies {

    private Long job_id;
    private Long apply_id;
    private String file;
    private String description;
    private String username;
    private long send_date;
    private long end_date;

    public Applies() {
    }

    @Override
    public String toString() {
        return "Applies{" +
                "job_id=" + job_id +
                ", apply_id=" + apply_id +
                ", file='" + file + '\'' +
                ", description='" + description + '\'' +
                ", username='" + username + '\'' +
                ", send_date=" + send_date +
                ", end_date=" + end_date +
                '}';
    }

    public Long getJob_id() {
        return job_id;
    }

    public void setJob_id(Long job_id) {
        this.job_id = job_id;
    }

    public Long getApply_id() {
        return apply_id;
    }

    public void setApply_id(Long apply_id) {
        this.apply_id = apply_id;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public long getEnd_date() {
        return end_date;
    }

    public void setEnd_date(long end_date) {
        this.end_date = end_date;
    }
}
