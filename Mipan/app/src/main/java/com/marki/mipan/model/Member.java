package com.marki.mipan.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;

public class Member {
    private static final Member ourInstance = new Member();

    public static Member getInstance() {
        return ourInstance;
    }

    public  FirebaseDatabase firebaseDatabase ;
    public  DatabaseReference dbRef;

    private String username;
    private String type;
    private boolean has_username;
    private boolean is_guest;
    private long mip_coin;
    private long birthdate;
    private String full_name ;
    private String password;
    private String email;
    private String sex;
    private String city;
    private long create_date;
    private long[] open_date;
    private long[] applies;
    private long[] events;

    private Member() {
    }

    @Override
    public String toString() {
        return "Member{" +
                "username='" + username + '\'' +
                ", type='" + type + '\'' +
                ", has_username=" + has_username +
                ", is_guest=" + is_guest +
                ", mip_coin=" + mip_coin +
                ", birthdate=" + birthdate +
                ", full_name='" + full_name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", city='" + city + '\'' +
                ", create_date=" + create_date +
                ", open_date=" + Arrays.toString(open_date) +
                ", applies=" + Arrays.toString(applies) +
                ", events=" + Arrays.toString(events) +
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

    public long getMip_coin() {
        return mip_coin;
    }

    public void setMip_coin(long mip_coin) {
        this.mip_coin = mip_coin;
    }

    public long getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(long birthdate) {
        this.birthdate = birthdate;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getCreate_date() {
        return create_date;
    }

    public void setCreate_date(long create_date) {
        this.create_date = create_date;
    }

    public long[] getOpen_date() {
        return open_date;
    }

    public void setOpen_date(long[] open_date) {
        this.open_date = open_date;
    }

    public long[] getApplies() {
        return applies;
    }

    public void setApplies(long[] applies) {
        this.applies = applies;
    }

    public long[] getEvents() {
        return events;
    }

    public void setEvents(long[] events) {
        this.events = events;
    }
}
