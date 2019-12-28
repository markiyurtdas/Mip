package com.marki.mipan.model;

import java.util.Arrays;
import java.util.List;

public class Event {
    private long event_id;
    private long mip_coin;

    private String photo;
    private long date;
    private String description;
    private String title;
    private double locLat;
    private double locLon;

    public double getLocLat() {
        return locLat;
    }

    public void setLocLat(double locLat) {
        this.locLat = locLat;
    }

    public double getLocLon() {
        return locLon;
    }

    public void setLocLon(double locLon) {
        this.locLon = locLon;
    }

    private List<String> users;
    public String getPhotoUrl() {
        return photo;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photo = photoUrl;
    }

    public long getMip_coin() {
        return mip_coin;
    }

    public void setMip_coin(long mip_coin) {
        this.mip_coin = mip_coin;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(long event_id) {
        this.event_id = event_id;
    }


    public Event() {
    }


    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }
//    private long


    @Override
    public String toString() {
        return "Event{" +
                "date=" + date +
                ", event_id=" + event_id +
                ", description='" + description + '\'' +
                ", photo='" + photo + '\'' +
                ", loc_lat=" + locLat +
                ", loc_lon=" + locLon +
                ", mip_coin=" + mip_coin +
                ", title='" + title + '\'' +
                ", users=" + users +
                '}';
    }
}
