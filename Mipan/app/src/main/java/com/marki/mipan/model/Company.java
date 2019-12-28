package com.marki.mipan.model;

import java.util.Arrays;
import java.util.List;

public class Company {
    @Override
    public String toString() {
        return "Company{" +
                "address='" + address + '\'' +
                ", company_name='" + company_name + '\'' +
                ", job_list=" + job_list +
                ", location=" + location +
                ", photos=" + photos +
                ", company_id=" + company_id +
                '}';
    }

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

    public List<Long> getJob_list() {
        return job_list;
    }

    public void setJob_list(List<Long> job_list) {
        this.job_list = job_list;
    }

    public List<Long> getLocation() {
        return location;
    }

    public void setLocation(List<Long> location) {
        this.location = location;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public Long getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Long company_id) {
        this.company_id = company_id;
    }

    private String address;
    private String company_name;
    private List<Long> job_list;
    private List<Long> location;
    private List<String> photos;
    private Long company_id;


}
