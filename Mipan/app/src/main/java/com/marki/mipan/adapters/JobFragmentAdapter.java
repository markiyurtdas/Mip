package com.marki.mipan.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.marki.mipan.R;
import com.marki.mipan.activities.Chat;
import com.marki.mipan.activities.CompanyDetail;
import com.marki.mipan.model.Company;
import com.marki.mipan.model.Event;
import com.marki.mipan.model.JobAds;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class JobFragmentAdapter extends RecyclerView.Adapter<JobFragmentAdapter.MyViewHolder>  {
    private Context mContext;
    public ArrayList<JobAds> mDataset;



    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        public TextView tvTitle;
        public TextView tvDescription;



        public MyViewHolder(LinearLayout v) {
            super(v);

            tvTitle = v.findViewById(R.id.tv_titlejob);
            tvDescription = v.findViewById(R.id.tv_description);
        }
    }
    public JobFragmentAdapter(ArrayList<JobAds> myDataset, Context mContext) {
        this.mDataset = myDataset;
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        LinearLayout v =  (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_joblist, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        JobAds e = mDataset.get(position);

        holder.tvTitle.setText(e.getTitle());
        holder.tvDescription.setText(e.getDescription());
        holder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i=new Intent(mContext, CompanyDetail.class);
                i.putExtra("send",position);
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size() ;
    }



}
