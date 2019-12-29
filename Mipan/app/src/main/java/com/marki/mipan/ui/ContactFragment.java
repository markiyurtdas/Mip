package com.marki.mipan.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.marki.mipan.R;
import com.marki.mipan.adapters.ChatListAdapter;
import com.marki.mipan.model.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ContactFragment extends Fragment {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ChatListAdapter mAdapter;
    Member member=Member.getInstance();
    String sentTo="mehmet";
    String sender= "ahmet";
    ArrayList<String> msgList = new ArrayList<>();
    private Spinner spinnerCall;
    private TextView tv_number,tv_number1,tv_number2;
    Button btnCall,btnMessages;
    Context mContext;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_contact, container, false);

        mContext=root.getContext();
        recyclerView = root.findViewById(R.id.rec_message_members);
        getUserMessage();
        spinnerCall=root.findViewById(R.id.spinner_emergency_number);
        btnCall=root.findViewById(R.id.btn_call);
        btnMessages=root.findViewById(R.id.btn_messages);

        List<String> list=new ArrayList<>();
        list.add("55");
        list.add("22");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                R.layout.spinner_item_emergency, list);

        adapter.setDropDownViewResource(R.layout.spinner_item_emergency);

        spinnerCall.setAdapter(adapter);
        spinnerCall.setSelection(0);
        spinnerCall.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                btnCall.setText(list.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return root;
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

        linearLayoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        mAdapter = new ChatListAdapter(list,mContext);
        recyclerView.setAdapter(mAdapter);
    }
}