package com.marki.mipan.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.marki.mipan.R;
import com.marki.mipan.adapters.ChatListAdapter;
import com.marki.mipan.adapters.ChatListAdapter2;
import com.marki.mipan.model.Member;
import com.marki.mipan.safe.Control;
import com.marki.mipan.ui.ContactFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ChatActivity extends AppCompatActivity {
    RecyclerView recyclerView2;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager2;
    LinearLayoutManager linearLayoutManager;
    ChatListAdapter2 mAdapter2;
    Member member = Member.getInstance();
    ChatListAdapter mAdapter;
    ArrayList<String> msgList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat2);
        if (!member.isIs_guest()){
            getUserMessage();
        }
        recyclerView2 = findViewById(R.id.rec_all_members);
        recyclerView = findViewById(R.id.rec_message_members);

        updateRecycle2(Control.memberList);


    }


    public void updateRecycle(ArrayList<String> list){
        recyclerView.setHasFixedSize(true);

        linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        mAdapter = new ChatListAdapter(list,getApplicationContext());
        recyclerView.setAdapter(mAdapter);
    }
    public void updateRecycle2(ArrayList<Member> list){
        recyclerView2.setHasFixedSize(true);

        linearLayoutManager2 = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView2.setLayoutManager(linearLayoutManager2);

        mAdapter2 = new ChatListAdapter2(list,getApplicationContext());
        recyclerView2.setAdapter(mAdapter2);
    }
    public void getUserMessage(){

        member.dbRef.child("message").child(member.getUsername())
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
                .child(member.getUsername())
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

}
