package com.marki.mipan.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.marki.mipan.Constants;
import com.marki.mipan.R;
import com.marki.mipan.activities.JobDetail;
import com.marki.mipan.model.JobAds;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class JobFragmentAdapter extends RecyclerView.Adapter<JobFragmentAdapter.MyViewHolder>  {
    public Context mContext;
    public ArrayList<JobAds> mDataset;



    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case

        public TextView tvTitle;
        public TextView tvCompany;
        public TextView tvDescription;
        public ImageView imageView;


        public MyViewHolder(LinearLayout v) {
            super(v);

            tvTitle = v.findViewById(R.id.job_title);
            tvCompany = v.findViewById(R.id.job_company);
            imageView = v.findViewById(R.id.img_job);
            tvDescription = v.findViewById(R.id.job_desc);
            v.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

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

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,JobDetail.class);
                intent.putExtra("pos",position);
                mContext.startActivity(intent);
                Toast.makeText(mContext, "pos:"+position, Toast.LENGTH_SHORT).show();
            }
        });
        holder.tvTitle.setText(e.getTitle());
        holder.tvDescription.setText(e.getDescription());
        holder.tvCompany.setText(e.getCompany());
        try {
            Picasso.with(mContext).load(e.getPhoto_url()).into(holder.imageView);
        }catch (IllegalArgumentException ie){
            try{
                Picasso.with(mContext).load(Constants.photoUrl).into(holder.imageView);
            }catch (Exception ex){
                ex.printStackTrace();
            }
            ie.printStackTrace();
        }
    }



    @Override
    public int getItemCount() {
        return mDataset.size() ;
    }



}
