package com.marki.mipan.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.marki.mipan.Constants;
import com.marki.mipan.R;
import com.marki.mipan.model.JobAds;
import com.marki.mipan.model.Member;
import com.marki.mipan.safe.Control;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class JobDetail extends AppCompatActivity {

    ArrayList<JobAds> A=Control.jobList;
Member member = Member.getInstance();
    public TextView tvCompany;
    public TextView tvCreateDate;
    public TextView tvEndDate;
    public TextView tvDesc;
    public TextView tvMail;
    public TextView tvTitle;
    public TextView tvType;
    public ImageView imageView;
    JobAds j;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobdetail);
        Intent i = getIntent();


        int position=i.getIntExtra("pos",-1);
        j= A.get(position);

        setupUI();
        getSupportActionBar().setTitle(j.getTitle());



    }

    private void setupUI() {
        tvCompany = findViewById(R.id.jodetail_company);
        tvCreateDate = findViewById(R.id.jodetail_create_date);
        tvEndDate = findViewById(R.id.jodetail_end_date);
        tvDesc = findViewById(R.id.jodetail_desc);
        tvMail = findViewById(R.id.jodetail_company_mail);
        tvTitle = findViewById(R.id.jodetail_title);
        tvType = findViewById(R.id.jodetail_type);
        imageView = findViewById(R.id.detail_img);

        tvCompany.setText(j.getCompany());
        tvCreateDate.setText(String.valueOf(j.getCreated_date()));
        tvEndDate.setText(String.valueOf(j.getEnd_date()));
        tvDesc.setText(j.getDescription());
        tvMail.setText(j.getCompany_mail());
        tvTitle.setText(j.getTitle());
        tvType.setText(j.getType());
        try {
            Picasso.with(JobDetail.this).load(j.getPhoto_url()).into(imageView);
        }catch (IllegalArgumentException ie){
            Picasso.with(JobDetail.this).load(Constants.photoUrl).into(imageView);
            ie.printStackTrace();
        }






    }


    @Override
    public void onResume() {


        if(!member.isIs_guest()){
        String childName ="5";
        member.dbRef.child("mip")
                .child("member")
                .child(member.getUsername())
                .child("event_user_log")
                .child(childName)
                .child("home")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        long homeValue = (long) dataSnapshot.getValue();
                        homeValue++;
                        member.dbRef.child("mip")
                                .child("member")
                                .child("arzutek1")
                                .child("event_user_log")
                                .child(childName)
                                .child("home")
                                .setValue(homeValue);
                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });}

        super.onResume();
    }
}
