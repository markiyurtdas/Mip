package com.marki.mipan.model;

import java.util.Arrays;
import java.util.List;

public class Event {
    private long event_id;
    private String photoUrl;

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(long event_id) {
        this.event_id = event_id;
    }

    private long date;
    private String description;

    private String title;
    private double[] location;
    private List<Member> users;

    public Event() {
    }

    @Override
    public String toString() {
        return "Event{" +
                "date=" + date +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", location=" + Arrays.toString(location) +
                ", users=" + users +
                '}';
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

    public double[] getLocation() {
        return location;
    }

    public void setLocation(double[] location) {
        this.location = location;
    }

    public List<Member> getUsers() {
        return users;
    }

    public void setUsers(List<Member> users) {
        this.users = users;
    }
//    private long
}
