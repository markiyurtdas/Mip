package com.marki.mipan.model;

import java.util.Arrays;
import java.util.List;

public class Event {
    @Override
    public String toString() {
        return "Event{" +
                "event_id=" + event_id +
                ", mip_coin=" + mip_coin +
                ", users=" + users +
                ", photo='" + photo + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", locLat=" + loclat +
                ", locLon=" + loclon +
                '}';
    }

    public long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(long event_id) {
        this.event_id = event_id;
    }

    public long getMip_coin() {
        return mip_coin;
    }

    public void setMip_coin(long mip_coin) {
        this.mip_coin = mip_coin;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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

    public String getLocLat() {
        return loclat;
    }

    public void setLocLat(String locLat) {
        this.loclat = loclat;
    }

    public String getLocLon() {
        return loclon;
    }

    public void setLocLon(String locLon) {
        this.loclon = loclon;
    }

    private long event_id;
    private long mip_coin;
    private List<User> users;
    private String photo;
    private long date;
    private String description;
    private String title;
    private String loclat;
    private String loclon;


}
class User{
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;
}
