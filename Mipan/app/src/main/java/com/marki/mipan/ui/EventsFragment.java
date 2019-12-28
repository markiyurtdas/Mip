package com.marki.mipan.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.marki.mipan.R;
import com.marki.mipan.model.Event;

import java.util.ArrayList;

public class EventsFragment extends Fragment {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_events, container, false);





        return root;
    }


    private void updateRecycle(ArrayList<Event> listOfUrl) {

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);


        // use a linear layout manager
        layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);




        // specify an adapter (see also next example)
        mAdapter = new CreatedCampaignsAdapter(listOfUrl,mContext,getActivity().getSupportFragmentManager());
        recyclerView.setAdapter(mAdapter);

    }
}