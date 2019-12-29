package com.marki.mipan.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.marki.mipan.R;


import java.util.ArrayList;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.MyViewHolder>  {
    private Context mContext;
    public ArrayList<String> mDataset;



    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView name;

        public MyViewHolder(LinearLayout v) {
            super(v);

            name = v.findViewById(R.id.tv_yemek);
        }
    }
    public FoodListAdapter(ArrayList<String> myDataset, Context mContext) {
        this.mDataset = myDataset;
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public FoodListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        LinearLayout v =  (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_yemek, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
      holder.name.setText(mDataset.get(0));

    }

    @Override
    public int getItemCount() {
        return mDataset.size() ;
    }



}