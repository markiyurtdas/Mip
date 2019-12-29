package com.marki.mipan.manage;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.marki.mipan.R;
import com.marki.mipan.model.JobAds;
import com.marki.mipan.model.Member;
import com.marki.mipan.model.Survey;
import com.marki.mipan.safe.Control;

import java.util.ArrayList;
import java.util.HashMap;

public class SurveyCreate extends AppCompatActivity {
    Member member=Member.getInstance();
    TextView answersV;
    TextView choisesV;
    TextView created_dateV;
    TextView descriptionV;
    TextView enddateV;
    TextView mip_coinV;
    TextView questionV;
    TextView titleV;


   ArrayList<Survey> surveyList = Control.surveyList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createsurvey);

        answersV.findViewById(R.id.tv_answersurvey);
        choisesV.findViewById(R.id.tv_choisessurvey);
        created_dateV.findViewById(R.id.tv_startdatesurvey);
        descriptionV.findViewById(R.id.tv_descriptionsurvey);
        enddateV.findViewById(R.id.tv_enddatesurvey);
        mip_coinV.findViewById(R.id.tv_mipcoinsurvey);
        questionV.findViewById(R.id.tv_questionsurvey);
        mip_coinV.findViewById(R.id.tv_mipcoinsurvey);
        titleV.findViewById(R.id.tv_titlesurvey);


        String answers=answersV.getText().toString();
        String choises=choisesV.getText().toString();
        String created_date=created_dateV.getText().toString();
        String  description=descriptionV.getText().toString();
        String enddate=enddateV.toString();
        String  creator_username="username";
        String  mip_coin=mip_coinV.getText().toString();
        String question=questionV.getText().toString();
        String survey_id="ss";
        String title=titleV.getText().toString();


        HashMap<String, Object> h = new HashMap<>();

        h.put("answers",answers);
        h.put("choises",choises);
        h.put("created_date",created_date);
        h.put("description",description);
        h.put("enddate",enddate);
        h.put("creator_username",creator_username);
        h.put("title",title);
        h.put("mip_coin",mip_coin);
        h.put("question",question);
        h.put("survey_id",survey_id);
        member.dbRef.child("mip")
                .child("survey")
                .child(surveyList.size()+"")
                .updateChildren(h);
    }
}
