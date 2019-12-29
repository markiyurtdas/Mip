package com.marki.mipan.activities;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.marki.mipan.R;
import com.marki.mipan.adapters.ChatListAdapter;
import com.marki.mipan.model.Member;
import com.marki.mipan.model.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ChatList extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ChatListAdapter mAdapter;
    Member member=Member.getInstance();
    String sentTo="mehmet";
    String sender= "ahmet";
    ArrayList<String> msgList = new ArrayList<>();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatlist);

        recyclerView = findViewById(R.id.rec_chatList);
        getUserMessage();


    }

    public void getUserMessage(){

        member.dbRef.child("message").child(sender)
                .child("sendTo")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChildren()){
                            HashMap<String,String> myHash = (HashMap<String, String>) dataSnapshot.getValue();
                            Set<String> setList = myHash.keySet();
                            for (String s:setList){
                                msgList.add(s);
                            }
                            getAllRecMessages();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
    }

    public void getAllRecMessages(){
        member.dbRef.child("message")
                .child(sender)
                .child("receive")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChildren()){
                            HashMap<String,Object> myHash = (HashMap<String, Object>) dataSnapshot.getValue();
                            Set<String> setList = myHash.keySet();
                            for (String s:setList){
                                if(!(msgList.contains(s))){
                                    msgList.add(s);
                                }
                            }
                            System.out.println(msgList);
                            updateRecycle(msgList);
                        }

                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
    }

    public void updateRecycle(ArrayList<String> list){
        recyclerView.setHasFixedSize(true);

        linearLayoutManager = new LinearLayoutManager(ChatList.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        mAdapter = new ChatListAdapter(list,ChatList.this);
        recyclerView.setAdapter(mAdapter);
    }
}