package com.marki.mipan.manage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    public EditText dateV;
    public EditText descriptionV;
    public EditText mipcoinV;
    public EditText photoV;
    public EditText titleV;
    public Button  btnSend;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createevent);

        btnSend=findViewById(R.id.btnSend);
        dateV =findViewById(R.id.tv_date);
        descriptionV=findViewById(R.id.tv_descriptionevent);
        mipcoinV=findViewById(R.id.tv_mipcoinevent);
        photoV=findViewById(R.id.tv_photo_event);
        titleV=findViewById(R.id.tv_titlevent);





        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long date=Long.parseLong(dateV.getText().toString());
                String description=descriptionV.getText().toString();
                String loclat="123122s23";
                String  loclon="231s22231";
                long mipcoin=Long.parseLong(mipcoinV.getText().toString());
                String  photo=photoV.getText().toString();
                String  title=titleV.getText().toString();
                long event_id=4;

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

                Toast.makeText(CreateEvent.this, "Başarıyla gönderildi", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }
}
