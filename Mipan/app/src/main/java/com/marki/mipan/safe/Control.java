package com.marki.mipan.safe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.marki.mipan.R;
import com.marki.mipan.model.Event;
import com.marki.mipan.model.Member;

import org.json.JSONObject;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Control extends AppCompatActivity {
    public static ArrayList<Event> eventList = new ArrayList<Event>();
    Member member = Member.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        getEvents();




    }

    public void getEvents(){


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

    }
}
