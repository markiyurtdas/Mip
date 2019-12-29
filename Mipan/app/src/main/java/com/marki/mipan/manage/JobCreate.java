package com.marki.mipan.manage;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.marki.mipan.R;
import com.marki.mipan.model.Event;
import com.marki.mipan.model.JobAds;
import com.marki.mipan.model.Member;
import com.marki.mipan.safe.Control;

import java.util.ArrayList;
import java.util.HashMap;

public class JobCreate extends AppCompatActivity {
    Member member=Member.getInstance();
    public static ArrayList<JobAds> jobList = Control.jobList;

    TextView companyV;
    TextView company_mailV;
    TextView created_dateV;
    TextView descriptionV;
    TextView enddateV;
    TextView photo_urlV;
    TextView titleV;
    TextView typeV;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createjob);



        companyV.findViewById(R.id.tv_companyjob);
        descriptionV.findViewById(R.id.tv_description);
        created_dateV.findViewById(R.id.tv_startdate);
        company_mailV.findViewById(R.id.tv_companymailjob);
        titleV.findViewById(R.id.tv_titlejob);
        enddateV.findViewById(R.id.tv_enddatejob);
        photo_urlV.findViewById(R.id.tv_photojob);
        typeV.findViewById(R.id.tv_typejob);

        String company=companyV.getText().toString();
        String description=descriptionV.getText().toString();
        String company_mail=company_mailV.getText().toString();
        String  created_date=created_dateV.getText().toString();
        String enddate=enddateV.getText().toString();
        String  photo_url=photo_urlV.getText().toString();
        String  title=titleV.getText().toString();
        String type=typeV.getText().toString();
        String job_id="";


        HashMap<String, Object> h = new HashMap<>();

        h.put("company",company);
        h.put("company_mail",company_mail);
        h.put("description",description);
        h.put("enddate",enddate);
        h.put("job_id",job_id);
        h.put("photo_url",photo_url);
        h.put("title",title);
        h.put("type",type);
        member.dbRef.child("mip")
                .child("job_ad")
                .child(jobList.size()+"")
                .updateChildren(h);
    }
}
