package com.marki.mipan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.github.loadingview.LoadingDialog;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.marki.mipan.activities.Chat;
import com.marki.mipan.activities.ChatList;
import com.marki.mipan.model.Member;
import com.marki.mipan.safe.Control;

public class StartActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;
    private static final String TAG = "StartActivity";

    Member member = Member.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        LoadingDialog dialog = LoadingDialog.Companion.get(this);
        //noinspection KotlinInternalInJava
        dialog.getLoadingView$loadingview_release().setDuration(90);
        //dialog.hide();
        // later dismiss
        //dialog.show();


        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        // Write a message to the database
        member.firebaseDatabase= FirebaseDatabase.getInstance();
        member.dbRef = member.firebaseDatabase.getReference();




        member.dbRef.child("mip")
                .child("member")
                .child("mynickname")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChildren()){
                          //  System.out.println(dataSnapshot.getValue().toString());
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

        //Firebase pushNotification için token id alınıp fcm-token kısmına database'e kaydedilir

        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "getInstanceId failed", task.getException());
                            return;
                        }

                        // Telefon için token id alınır
                        String token = task.getResult().getToken();


                        String msg = token;
                        Log.d(TAG, msg);
                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        DatabaseReference myRef = database.getReference();



                        myRef.child("fcm-token").child(token).setValue(token).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    System.out.println("Token Kaydedildi");
                                }
                            }
                        });


                    }
                });



        startActivity(new Intent(StartActivity.this, ChatList.class));
//        startActivity(new Intent(StartActivity.this, FragmentMainActivity.class));
    }
}
