package com.marki.mipan.model;

public class Guest {
    public boolean isIs_guest() {
        return is_guest;
    }

    public void setIs_guest(boolean is_guest) {
        this.is_guest = is_guest;
    }

    public Long[] getOpen_date() {
        return open_date;
    }

    public void setOpen_date(Long[] open_date) {
        this.open_date = open_date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isHas_username() {
        return has_username;
    }

    public void setHas_username(boolean has_username) {
        this.has_username = has_username;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    private  String create_date;
    private  boolean has_username;
    private  boolean is_guest;
    private  Long[] open_date;
    private  String type;
    private  String username;
}
