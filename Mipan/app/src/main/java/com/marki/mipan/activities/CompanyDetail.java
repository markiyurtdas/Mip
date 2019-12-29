package com.marki.mipan.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.marki.mipan.R;
import com.marki.mipan.model.JobAds;
import com.marki.mipan.safe.Control;

import java.util.ArrayList;

public class CompanyDetail extends AppCompatActivity {

    ArrayList<JobAds> A=Control.jobList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobdetail);
        Intent i = getIntent();

        String position=i.getStringExtra("sender");
        JobAds jobAds= A.get(Integer.parseInt(position));

        getSupportActionBar().setTitle(jobAds.getTitle());

            //TODO:Gösterilecek Bildiler
                    jobAds.getPhoto_url();
                    jobAds.getCompany_mail();
                    jobAds.getCreated_date();
                    jobAds.getDescription();
                    jobAds.getType();

    }
}
