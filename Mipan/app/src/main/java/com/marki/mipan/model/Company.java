package com.marki.mipan.model;

public class Company {
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public Long[] getJob_list() {
        return job_list;
    }

    public void setJob_list(Long[] job_list) {
        this.job_list = job_list;
    }

    public Long[] getLocation() {
        return location;
    }

    public void setLocation(Long[] location) {
        this.location = location;
    }

    public String[] getPhotos() {
        return photos;
    }

    public void setPhotos(String[] photos) {
        this.photos = photos;
    }

    private String address;
    private String company_name;
    private Long[] job_list;
    private Long[] location;
    private String[] photos;
    private Long company_id;

    public Long getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Long company_id) {
        this.company_id = company_id;
    }
}
