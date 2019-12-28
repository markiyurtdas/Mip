package com.marki.mipan.activities;

import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseError;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.marki.mipan.R;
import com.marki.mipan.model.Member;

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
    String sentTo="mehmet";
    String sender= "ahmet";
    Boolean first =false,giris=true;

     ArrayList<Message> MessageList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        layout = (LinearLayout) findViewById(R.id.layout1);
        layout_2 = (RelativeLayout) findViewById(R.id.layout2);
        sendButton = (ImageView) findViewById(R.id.sendButton);
        messageArea = (EditText) findViewById(R.id.messageArea);
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageText = messageArea.getText().toString();

                HashMap<String, Object> h = new HashMap<>();

                h.put(String.valueOf((System.currentTimeMillis()/1000L)),messageText);
                member.dbRef.child("message")
                        .child(sender)
                        .child("sendTo")
                        .child(sentTo)
                        .updateChildren(h);

                messageArea.setText("");


            }
        });




            myRef.child("message").child(sender).child("receive").child(sentTo).addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {


                    addMessageBox(dataSnapshot.getValue().toString(), 1);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }


            });

            myRef.child("message").child(sender).child("sendTo").child(sentTo).addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {


                    addMessageBox(dataSnapshot.getValue().toString(), 2);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }


            });

    }

    public void sortMessageListList(){
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
    }


    public String getReceivedMessage(String sentTo){

        member.dbRef.child("message").child(sender).child("receive").child(sentTo).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //System.out.println( dataSnapshot.getValue().toString()+"aaaaaaaaa");
                // String message = map.get("").toString();
               HashMap<String,String> h = (HashMap<String,String>) dataSnapshot.getValue();

                Set<String> strList = h.keySet();
                for (String key:strList){
                    Message m = new Message();
                    m.setMessages(h.get(key));
                    m.setTime(Long.parseLong(key.toString()));
                    m.setType(1);

                    MessageList.add(m);

                }

                System.out.println("zxc " + MessageList.get(0).getMessages());


                //message = dataSnapshot.getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return "";
    }

    public String getSentToMessage(String sender){

        member.dbRef.child("message").child(sender).child("sendTo").child(sentTo).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                // String message = map.get("").toString();
                HashMap<String,String> h = (HashMap<String,String>) dataSnapshot.getValue();

                Set<String> strList = h.keySet();
                for (String key:strList){
                    Message m = new Message();
                    m.setMessages(h.get(key));
                    m.setTime(Long.parseLong(key.toString()));
                    m.setType(2);

                    MessageList.add(m);

                }

                //System.out.println("zxc " + receivedMessageList.get(0).getMessages());


                //message = dataSnapshot.getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return "";
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

    class Message{
        private long time;
        private String messages;
        private int type;

        public Message( ) {
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public Message(long time, String messages) {
            this.time = time;
            this.messages = messages;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public String getMessages() {
            return messages;
        }

        public void setMessages(String messages) {
            this.messages = messages;
        }
    }


}