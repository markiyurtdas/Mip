package com.marki.mipan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
import com.marki.mipan.activities.FirstActivity;
import com.marki.mipan.activities.SignUP;
import com.marki.mipan.model.Member;
import com.marki.mipan.safe.Control;
import java.util.HashMap;

public class StartActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;
    private static final String TAG = "StartActivity";

    Button btnSignUp;
    Button btnEnter;
    Button btnGuest;
    Button btnManage;
    EditText etUsername;
    EditText etPassword;


    Member member = Member.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        LoadingDialog dialog = LoadingDialog.Companion.get(this);
        //noinspection KotlinInternalInJava
        dialog.getLoadingView$loadingview_release().setDuration(90);
        setupUI();
        //dialog.hide();
        // later dismiss
        //dialog.show();
        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        // Write a message to the database
        member.firebaseDatabase= FirebaseDatabase.getInstance();
        member.dbRef = member.firebaseDatabase.getReference();



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


        }

    private void setupUI() {
        btnEnter = findViewById(R.id.btn_enter);
        btnSignUp = findViewById(R.id.btn_signup);
        btnGuest = findViewById(R.id.btn_guest);
        btnManage = findViewById(R.id.btn_manage);

        etUsername = findViewById(R.id.et_start_username);
        etPassword = findViewById(R.id.et_start_password);

        btnManage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this,Control.class);
                intent.putExtra("posi",3);
                startActivity(intent);
            }
        });

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean devam = false;
                if(etUsername.getText().toString().length()<4){
                    Toast.makeText(StartActivity.this, "Kullanıcı adı 4 ten küçük olamaz", Toast.LENGTH_SHORT).show();
                }else {
                    member.dbRef.child("mip")
                            .child("member")
                            .child(etUsername.getText().toString())
                            .addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    if (dataSnapshot.hasChildren()){
                                        HashMap<String,Object> mTemp = (HashMap<String, Object>) dataSnapshot.getValue();
                                        if (etPassword.getText().toString().equals(mTemp.get("password").toString())){
                                            Intent intent = new Intent(StartActivity.this, Control.class);
                                            intent.putExtra("username",etUsername.getText().toString());
                                            member.setIs_guest(false);
                                            startActivity(intent);
                                        }else {
                                            Toast.makeText(StartActivity.this, "Parola hatalı", Toast.LENGTH_SHORT).show();
                                        }

                                    }else {
                                        Toast.makeText(StartActivity.this, "Kullanıcı yok", Toast.LENGTH_SHORT).show();
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                }

            }
        });


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartActivity.this, SignUP.class));

            }
        });
        btnGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartActivity.this,FirstActivity.class));
            }
        });


    }


}

