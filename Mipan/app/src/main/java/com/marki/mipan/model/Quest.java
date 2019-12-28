package com.marki.mipan.model;

import java.util.List;

public class Quest {
    private String username;
    private String type;
    private boolean has_username;
    private boolean is_guest;
    private long create_date;
    private List<Long> open_date;

    public Quest() {
    }

    @Override
    public String toString() {
        return "Quest{" +
                "username='" + username + '\'' +
                ", type='" + type + '\'' +
                ", has_username=" + has_username +
                ", is_guest=" + is_guest +
                ", create_date=" + create_date +
                ", open_date=" + open_date +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isHas_username() {
        return has_username;
    }

    public void setHas_username(boolean has_username) {
        this.has_username = has_username;
    }

    public boolean isIs_guest() {
        return is_guest;
    }

    public void setIs_guest(boolean is_guest) {
        this.is_guest = is_guest;
    }

    public long getCreate_date() {
        return create_date;
    }

    public void setCreate_date(long create_date) {
        this.create_date = create_date;
    }

    public List<Long> getOpen_date() {
        return open_date;
    }

    public void setOpen_date(List<Long> open_date) {
        this.open_date = open_date;
    }
}
