package com.marki.mipan.model;

import java.util.List;

public class Member {
    private String username;
    private String type;
    private boolean has_username;
    private boolean is_guest;
    private long score_point;
    private long birthdate;
    private String full_name;
    private String password;
    private String email;
    private String sex;
    private String city;
    private long create_date;
    private List<Long> open_date;
    private List<Integer> applies;
    private List<Integer> events;

    public Member() {
    }

    @Override
    public String toString() {
        return "Member{" +
                "username='" + username + '\'' +
                ", type='" + type + '\'' +
                ", has_username=" + has_username +
                ", is_guest=" + is_guest +
                ", score_point=" + score_point +
                ", birthdate=" + birthdate +
                ", full_name='" + full_name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", city='" + city + '\'' +
                ", create_date=" + create_date +
                ", open_date=" + open_date +
                ", applies=" + applies +
                ", events=" + events +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
