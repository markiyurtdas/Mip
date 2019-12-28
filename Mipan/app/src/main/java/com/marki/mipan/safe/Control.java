package com.marki.mipan.safe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.marki.mipan.R;
import com.marki.mipan.model.AnswerList;
import com.marki.mipan.model.Applies;
import com.marki.mipan.model.Company;
import com.marki.mipan.model.Event;
import com.marki.mipan.model.JobAds;
import com.marki.mipan.model.Member;
import com.marki.mipan.model.Survey;

import org.json.JSONObject;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Control extends AppCompatActivity {
    public static ArrayList<Event> eventList = new ArrayList<>();
    public static ArrayList<JobAds> jobList = new ArrayList<>();
    public static ArrayList<Applies> appliesList = new ArrayList<>();
    public static ArrayList<Company> companyList = new ArrayList<>();
    public static ArrayList<Survey> surveyList = new ArrayList<>();
    public static ArrayList<Member> memberList = new ArrayList<>();
    public static ArrayList<String> messageUsers = new ArrayList<>();
    public static List[][] messageMessages ;


    Member member = Member.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        //getEvents();
        //getJobAds();
        //getApplies();
        //getCompanies();
        //getAnswerList();
        //getSurvey();
        getMember();


    }
    public void getEvents(){

        member.dbRef.child("mip")
                .child("event")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot postSnapShot : dataSnapshot.getChildren()) {
                            Event myj = postSnapShot.getValue(Event.class);
                            eventList.add(myj);
                            System.out.println("bbc" + eventList.toString());
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


    }
   /* public void getEvents(){


        member.dbRef.child("mip")
                .child("event")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChildren()){
                            Gson gson = new Gson();
                            HashMap<String,Object> myHash = (HashMap<String, Object>) dataSnapshot.getValue();
                            Set<String> str = myHash.keySet();
                            for(String string:str){
                                Event mEvent =  new Event();


                                HashMap<String,Object> o = (HashMap<String, Object>) myHash.get(string);

                                mEvent.setDate((Long) o.get("date"));
                                mEvent.setDescription((String) o.get("description"));
                                long id = (long) o.get("event_id");
                                mEvent.setEvent_id(id);
                                mEvent.setLocLat((Double) o.get("loc_lat"));
                                mEvent.setLocLon((Double) o.get("loc_lon"));
                                mEvent.setMip_coin((Long) o.get("mip_coin"));
                                mEvent.setPhoto((String) o.get("description"));
                                mEvent.setTitle((String) o.get("title"));
                                eventList.add(mEvent);
                            }

                            System.out.println("zxc event list"+eventList.toString());
//                            JSONObject o = (JSONObject) jArray.get(i);
//                            User tempUser = gson.fromJson(o.toString(), User.class);
//                            for (int j = 0; j < o.getJSONArray("create_courses").length(); j++) {
//                                Course c = gson.fromJson(o.getJSONArray("create_courses").get(j).toString(), Course.class);
//                                tempUser.addToCreateCourses(c);
//                                kurslar.put(c.getCourse_name(),c);
//                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

    }*/
    public void getJobAds() {


        member.dbRef.child("mip")
                .child("job_ad")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot postSnapShot : dataSnapshot.getChildren()) {
                            JobAds myj = postSnapShot.getValue(JobAds.class);
                            jobList.add(myj);

                        }
                        System.out.println(jobList.toString());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

    }
    public void getApplies() {
        member.dbRef.child("mip")
                .child("applies")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot postSnapShot : dataSnapshot.getChildren()) {
                            Applies myj = postSnapShot.getValue(Applies.class);
                            appliesList.add(myj);
                            System.out.println(appliesList.toString());
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

    }
    public void getCompanies() {
        member.dbRef.child("mip")
                .child("company")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot postSnapShot : dataSnapshot.getChildren()) {
                            Company myj = postSnapShot.getValue(Company.class);
                            companyList.add(myj);
                            System.out.println("compan" + companyList.toString());
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

    }
    public void getSurvey() {
        member.dbRef.child("mip")
                .child("survey")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot postSnapShot : dataSnapshot.getChildren()) {
                            Survey myj = postSnapShot.getValue(Survey.class);
                            surveyList.add(myj);

                        }
                        System.out.println("surveyList" + surveyList.toString());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

    }
    public void getMember(){

        member.dbRef.child("mip")
                .child("member")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot postSnapShot : dataSnapshot.getChildren()) {
                            Member myj = postSnapShot.getValue(Member.class);
                            memberList.add(myj);

                        }
                        System.out.println("members" + memberList.toString());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


    }



    public void getUserMessages(){
        member.dbRef.child("message")
                .child(member.getUsername())
                .child("receive")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChildren()){
                            HashMap<String,Object> myHash = (HashMap<String, Object>) dataSnapshot.getValue();
                            Set<String> str = myHash.keySet();

                            for (String string:str){

                                //string mehmet
                                messageUsers.add(string);
                                HashMap<String,Object> mHash = (HashMap<String, Object>) myHash.get(string);
                                int index = messageUsers.indexOf(string);

                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
    }
}

