package com.marki.mipan.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.marki.mipan.R;
import com.marki.mipan.StartActivity;
import com.marki.mipan.model.Member;
import com.marki.mipan.safe.Control;

public class ProfilFragment extends Fragment {
    Member member = Member.getInstance();

    TextView tvFullname;
    TextView tvMipCoin;
    TextView tvMail;
    TextView tvPhone;
    TextView tvLocation;

    ImageView imageView;

    Button btnGoToLogin;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profil, container, false);
        btnGoToLogin = root.findViewById(R.id.btn_goto_login);
        tvFullname = root.findViewById(R.id.tv_p_name);
        tvMipCoin = root.findViewById(R.id.tv_mipcoin);
        tvMail = root.findViewById(R.id.tv_p_mail);
        tvLocation = root.findViewById(R.id.tv_p_loc);
        imageView= root.findViewById(R.id.tv_p_image);
        if (!member.isIs_guest()){
            root.findViewById(R.id.scrollView2).setVisibility(View.VISIBLE);
            tvFullname.setText(member.getFull_name());
            tvMipCoin.setText(String.valueOf(member.getMip_coin()));
            tvMail.setText(member.getEmail());
            tvLocation.setText(member.getCity());
        }else {
            btnGoToLogin.setVisibility(View.VISIBLE);
            root.findViewById(R.id.scrollView2).setVisibility(View.INVISIBLE);
            btnGoToLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    btnGoToLogin.setVisibility(View.INVISIBLE);
                    startActivity(new Intent(root.getContext(), StartActivity.class));
                }
            });
        }


        member.dbRef.child("mip")
                .child("member")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot postSnapShot : dataSnapshot.getChildren()) {
                            Member myj = postSnapShot.getValue(Member.class);
                            try {
                                if (member.getUsername().equals(myj.getUsername())){




                                    root.findViewById(R.id.scrollView2).setVisibility(View.VISIBLE);
                                    tvFullname.setText(myj.getFull_name());
                                    tvMipCoin.setText(String.valueOf(myj.getMip_coin()));
                                    tvMail.setText(myj.getEmail());
                                    tvLocation.setText(myj.getCity());


                                }
                            }catch (NullPointerException npExc){
                                npExc.printStackTrace();
                            }

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
        return root;
    }

    @Override
    public void onResume() {


        if(!member.isIs_guest()){

            String childName ="2";
        member.dbRef.child("mip")
                .child("member")
                .child(member.getUsername())
                .child("event_user_log")
                .child(childName)
                .child("home")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        long homeValue = (long) dataSnapshot.getValue();
                        homeValue++;
                        member.dbRef.child("mip")
                                .child("member")
                                .child("arzutek1")
                                .child("event_user_log")
                                .child(childName)
                                .child("home")
                                .setValue(homeValue);
                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });}

        super.onResume();
    }
}