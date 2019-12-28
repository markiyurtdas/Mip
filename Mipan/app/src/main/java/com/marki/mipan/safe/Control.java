package com.marki.mipan.safe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.marki.mipan.R;
import com.marki.mipan.activities.Chat;
import com.marki.mipan.model.AnswerList;
import com.marki.mipan.model.Applies;
import com.marki.mipan.model.Company;
import com.marki.mipan.model.Event;
import com.marki.mipan.model.JobAds;
import com.marki.mipan.model.Member;
import java.util.ArrayList;
import java.util.List;

public class Control extends AppCompatActivity {
    public static ArrayList<Event> eventList = new ArrayList<>();
    public static ArrayList<JobAds> jobList = new ArrayList<>();
    public static ArrayList<Applies> appliesList = new ArrayList<>();
    public static ArrayList<Company> companyList = new ArrayList<>();
    public static ArrayList<AnswerList> answerListList = new ArrayList<>();

    Member member = Member.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
        getEvents();
        getJobAds();
        getApplies();
        getCompanies();
        getAnswerList();

        startActivity(new Intent(Control.this, Chat.class));
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
    public void getAnswerList() {
        member.dbRef.child("mip")
                .child("answer_list")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot postSnapShot : dataSnapshot.getChildren()) {
                            AnswerList myj = postSnapShot.getValue(AnswerList.class);
                            answerListList.add(myj);

                        }
                        System.out.println("answerList" + answerListList.toString());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

    }

}

