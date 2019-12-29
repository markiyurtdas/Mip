package com.marki.mipan.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.marki.mipan.R;
import com.marki.mipan.adapters.JobFragmentAdapter;
import com.marki.mipan.model.JobAds;
import com.marki.mipan.model.Member;
import com.marki.mipan.safe.Control;

import java.util.ArrayList;

public class JobsFragment extends Fragment {

    LinearLayoutManager linearLayoutManager;
    RecyclerView recyclerView;
    JobFragmentAdapter mAdapter;
    Context mContext;

    Member member = Member.getInstance();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_jobs, container, false);
        recyclerView = root.findViewById(R.id.rec_jobList);
        mContext = root.getContext();
        updateRecycle(Control.jobList);

        return root;
    }

    private void updateRecycle(ArrayList<JobAds> list) {

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);


        // use a linear layout manager
        linearLayoutManager = new LinearLayoutManager(mContext,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);




        // specify an adapter (see also next example)
        mAdapter = new JobFragmentAdapter(list,mContext);
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onResume() {

        if(!member.isIs_guest()) {

            String childName = "3";
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
                    });
        }
        super.onResume();
    }

}