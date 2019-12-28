package com.marki.mipan.safe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.marki.mipan.R;
import com.marki.mipan.model.Event;
import com.marki.mipan.model.Member;

import java.util.ArrayList;

public class Control extends AppCompatActivity {
    public static ArrayList<Event> eventList = new ArrayList<Event>();
    Member member = Member.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);



    }

    public void getEvents(){


        member.dbRef.child("mip")
                .child("event")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChildren()){
                            eventList
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

    }
}
