package com.marki.mipan.model;

import java.util.List;

public class Event {
    private Integer event_id;
    private String title;
    private String description;
    private long date;
    private List<Long> location;
    private String photo;
    private List<String> users;

    public Event() {
    }

    @Override
    public String toString() {
        return "Event{" +
                "event_id=" + event_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", location=" + location +
                ", photo='" + photo + '\'' +
                ", users=" + users +
                '}';
    }

    public Integer getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Integer event_id) {
        this.event_id = event_id;
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

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public List<Long> getLocation() {
        return location;
    }

    public void setLocation(List<Long> location) {
        this.location = location;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }
}
