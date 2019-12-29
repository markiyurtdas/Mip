package com.marki.mipan.manage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.marki.mipan.R;
import com.marki.mipan.adapters.TypeListAdapter;
import com.marki.mipan.model.Member;
import android.provider.Settings.Secure;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.HashMap;


public class ManageStartPage extends AppCompatActivity {

    Member member = Member.getInstance();
    Button btnContinue;
    String userType;
    LinearLayout layout;
    LinearLayout.LayoutParams layoutParam;
    ArrayList<String>  typeList = new ArrayList<>();


    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    TypeListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_managestart);

        recyclerView = findViewById(R.id.rec_firstmanage);
        //TODO sil sonradan
        typeList.add("Event Oluştur");
        typeList.add("Anket Oluştur");
        typeList.add("İş İlanı");
        typeList.add("Message");

        updateRecycle(typeList);






    }

    private void updateRecycle(ArrayList<String> list) {

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);


        // use a linear layout manager
        linearLayoutManager = new LinearLayoutManager(ManageStartPage.this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);




        // specify an adapter (see also next example)
        mAdapter = new TypeListAdapter(list,ManageStartPage.this);
        recyclerView.setAdapter(mAdapter);

    }







}
