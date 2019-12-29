package com.marki.mipan.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseError;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.marki.mipan.R;
import com.marki.mipan.model.Member;
import com.marki.mipan.model.Message;
import com.marki.mipan.safe.Control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Chat extends AppCompatActivity {

    LinearLayout layout;
    RelativeLayout layout_2;
    ImageView sendButton;
    EditText messageArea;
    ScrollView scrollView;
    Member member=Member.getInstance();
    String sentTo="";
    Boolean first =false;
    public  ArrayList<Message> MessageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Intent i = getIntent();

        sentTo=i.getStringExtra("sender");
//        getReceivedMessage();
//        getSentToMessage();


        layout = (LinearLayout) findViewById(R.id.layout1);
        layout_2 = (RelativeLayout) findViewById(R.id.layout2);
        sendButton = (ImageView) findViewById(R.id.sendButton);
        messageArea = (EditText) findViewById(R.id.messageArea);
        scrollView = (ScrollView) findViewById(R.id.scrollView);

        getSupportActionBar().setTitle(sentTo);
//        getAllSendMessages();

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageText = messageArea.getText().toString();

                HashMap<String, Object> h = new HashMap<>();

                h.put(String.valueOf((System.currentTimeMillis()/1000L)),messageText);
                member.dbRef.child("message")
                        .child(member.getUsername())
                        .child("sendTo")
                        .child(sentTo)
                        .updateChildren(h);

                messageArea.setText("");
            }
        });






    }




    public void getReceivedMessage( ){

        member.dbRef.child("message").child(member.getUsername())
                .child("receive")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });    }

    public void getAllSendMessages(){
        String str = member.dbRef.child("message").child(member.getUsername())
                .child("sendTo")
                .child(sentTo)
                .toString();
    }
    public void getAllRecMessages(){
        member.dbRef.child("message")
                .child(member.getUsername())
                .child("receive")
                .child(sentTo)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChildren()){
                            HashMap<String,Object> myHash = (HashMap<String, Object>) dataSnapshot.getValue();
                            Set<String> setList = myHash.keySet();
                            for (String s:setList){
                                Message m = new Message();
                                m.setTime(Long.parseLong(s));
                                m.setMessages(myHash.get(s).toString());
                                m.setType(1);
                                MessageList.add(m);
                            }
                            sortMessageList();
                        }

                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
    }

//    public void getSentToMessage( ){
//
//
//        member.dbRef.child("message")
//                .child(member.getUsername())
//                .child("sendTo").addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//
//
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//                    layout.removeAllViews();
//                    MessageList.clear();
//                    getAllSendMessages();
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//
//
//        });
//    }


    public void sendScreen(){
        System.out.println("------size"+MessageList.size());
        for(int i=MessageList.size()-1;i>=0;i--){
            addMessageBox(MessageList.get(i).getMessages(),MessageList.get(i).getType());
        }
    }
    public void sortMessageList(){
        for (int i=0;i<MessageList.size()-1;i++){
            int maxIndx=i;
            for (int j=i+1;j<MessageList.size();j++){
                if (MessageList.get(j).getTime()>MessageList.get(maxIndx).getTime())
                    maxIndx=j;

                Message cTemp = MessageList.get(maxIndx);
                MessageList.set(maxIndx,MessageList.get(i));
                MessageList.set(i,cTemp);
            }
        }
        sendScreen();
    }





    public void addMessageBox(String message, int type){
        TextView textView = new TextView(Chat.this);
        textView.setText(message);

        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp2.weight = 1.0f;

        if(type == 1) {
            lp2.gravity = Gravity.LEFT;
            textView.setBackgroundResource(R.drawable.bubble_in);
        }
        else{
            lp2.gravity = Gravity.RIGHT;
            textView.setBackgroundResource(R.drawable.bubble_out);
        }
        textView.setLayoutParams(lp2);
        layout.addView(textView);

        scrollView.fullScroll(View.FOCUS_DOWN);
    }


    @Override
    protected void onResume() {

        member.dbRef.child("message")
                .child(member.getUsername())
                .child("sentTo")
                .child("hande")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        System.out.println("asdf"+dataSnapshot.getChildren().toString());

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
        super.onResume();
    }
}