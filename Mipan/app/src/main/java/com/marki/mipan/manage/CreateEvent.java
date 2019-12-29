package com.marki.mipan.manage;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.marki.mipan.R;
import com.marki.mipan.model.Event;
import com.marki.mipan.model.Member;
import com.marki.mipan.safe.Control;

import java.util.ArrayList;
import java.util.HashMap;

public class CreateEvent extends AppCompatActivity {

    Member member=Member.getInstance();
    public static ArrayList<Event> eventList = Control.eventList;
    TextView dateV;
    TextView descriptionV;
    TextView mipcoinV;
    TextView photoV;
    TextView titleV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createevent);

        dateV.findViewById(R.id.tv_date);
        descriptionV.findViewById(R.id.tv_descriptionevent);
        mipcoinV.findViewById(R.id.tv_mipcoinevent);
        photoV.findViewById(R.id.tv_photo_event);
        titleV.findViewById(R.id.tv_titlevent);

        String date=dateV.getText().toString();
        String description=descriptionV.getText().toString();
        String loclat="123122s23";
        String  loclon="231s22231";
        String mipcoin=mipcoinV.getText().toString();
        String  photo=photoV.getText().toString();
        String  title=titleV.getText().toString();
        String event_id="s4";



        HashMap<String, Object> h = new HashMap<>();

        h.put("date",date);
        h.put("description",description);
        h.put("loclat",loclat);
        h.put("loclon",loclon);
        h.put("mipcoin",mipcoin);
        h.put("photo",photo);
        h.put("title",title);
        h.put("event_id",event_id);
        member.dbRef.child("mip")
                .child("event")
                .child(eventList.size()+"")
                .updateChildren(h);
    }
}
