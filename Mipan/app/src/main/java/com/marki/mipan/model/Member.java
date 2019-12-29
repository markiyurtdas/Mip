package com.marki.mipan.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;
import java.util.List;

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
    private boolean is_guest=true;
    private long mip_coin;
    private long birthdate;
    private String full_name ;
    private String password;
    private String email;
    private String sex;
    private String city;
    private long create_date;
    private List<String> open_date;
    private List<Apply> applies;
    private List<EventLog> event_user_log;

    @Override
    public String toString() {
        return "Member{" +
                "firebaseDatabase=" + firebaseDatabase +
                ", dbRef=" + dbRef +
                ", username='" + username + '\'' +
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
                ", open_date=" + open_date +
                ", applies=" + applies +
                ", event_user_log=" + event_user_log +
                ", events=" + events +
                '}';
    }

    public List<EventLog> getEvent_user_log() {
        return event_user_log;
    }

    public void setEvent_user_log(List<EventLog> event_user_log) {
        this.event_user_log = event_user_log;
    }

    private List<Events> events;

    private Member() {
    }

    public static Member getOurInstance() {
        return ourInstance;
    }

    public FirebaseDatabase getFirebaseDatabase() {
        return firebaseDatabase;
    }

    public void setFirebaseDatabase(FirebaseDatabase firebaseDatabase) {
        this.firebaseDatabase = firebaseDatabase;
    }

    public DatabaseReference getDbRef() {
        return dbRef;
    }

    public void setDbRef(DatabaseReference dbRef) {
        this.dbRef = dbRef;
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

    public List<String> getOpen_date() {
        return open_date;
    }

    public void setOpen_date(List<String> open_date) {
        this.open_date = open_date;
    }

    public List<Apply> getApplies() {
        return applies;
    }

    public void setApplies(List<Apply> applies) {
        this.applies = applies;
    }

    public List<Events> getEvents() {
        return events;
    }

    public void setEvents(List<Events> events) {
        this.events = events;
    }

}
class Apply{
    private Long job_id;

    public Long getJob_id() {
        return job_id;
    }

    public void setJob_id(Long job_id) {
        this.job_id = job_id;
    }

    @Override
    public String toString() {
        return "Apply{" +
                "job_id=" + job_id +
                '}';
    }
}
class EventLog{
    private Long home;

    public Long getHome() {
        return home;
    }

    public void setHome(Long home) {
        this.home = home;
    }

    @Override
    public String toString() {
        return "EventLog{" +
                "home=" + home +
                '}';
    }
}
class Events{
    private Long event_id;

    public Long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Long event_id) {
        this.event_id = event_id;
    }

    @Override
    public String toString() {
        return "Events{" +
                "event_id=" + event_id +
                '}';
    }
}