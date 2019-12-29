package com.marki.mipan.ui;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.marki.mipan.R;
import com.marki.mipan.adapters.EventFragmentAdapter2;
import com.marki.mipan.adapters.JobFragmentAdapter2;
import com.marki.mipan.model.Event;
import com.marki.mipan.model.JobAds;
import com.marki.mipan.model.Member;
import com.marki.mipan.safe.Control;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HomeFragment extends Fragment {

    Member member = Member.getInstance();
    Context mComtext ;

    RecyclerView recyclerViewEvent;
    RecyclerView recyclerViewHome;
    LinearLayoutManager linearLayoutManagerEvent;
    LinearLayoutManager linearLayoutManagerHome;
    EventFragmentAdapter2 mAdapterEvent;
    JobFragmentAdapter2 mAdapterHome;
    Context mContext;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        mComtext = root.getContext();

        recyclerViewEvent = root.findViewById(R.id.rec_home_horizon);
        recyclerViewHome = root.findViewById(R.id.rec_home_fragment);

        updateRecycleEvent(Control.eventList);
        updateRecycleJob(Control.jobList);





        mComtext = root.getContext();
        return root;
    }

    private void updateRecycleEvent(ArrayList<Event> list) {

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerViewEvent.setHasFixedSize(true);


        // use a linear layout manager
        linearLayoutManagerEvent = new LinearLayoutManager(mContext,
                LinearLayoutManager.VERTICAL, false);
        recyclerViewEvent.setLayoutManager(linearLayoutManagerEvent);




        // specify an adapter (see also next example)
        mAdapterEvent = new EventFragmentAdapter2(list,mContext);
        recyclerViewEvent.setAdapter(mAdapterEvent);

    }
    private void updateRecycleJob(ArrayList<JobAds> list) {

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerViewHome.setHasFixedSize(true);


        // use a linear layout manager
        linearLayoutManagerHome = new LinearLayoutManager(mContext,
                LinearLayoutManager.VERTICAL, false);
        recyclerViewHome.setLayoutManager(linearLayoutManagerHome);




        // specify an adapter (see also next example)
        mAdapterHome = new JobFragmentAdapter2(list,mContext);
        recyclerViewHome.setAdapter(mAdapterHome);

    }

    @Override
    public void onResume() {


        if(!member.isIs_guest()){
            member.dbRef.child("mip")
                    .child("member")
                    .child(member.getUsername())
                    .child("event_user_log")
                    .child("0")
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
                                    .child("0")
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