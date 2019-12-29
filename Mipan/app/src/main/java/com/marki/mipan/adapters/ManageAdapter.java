package com.marki.mipan.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.marki.mipan.R;
import com.marki.mipan.manage.CreateEvent;
import com.marki.mipan.manage.JobCreate;
import com.marki.mipan.manage.SurveyCreate;
import com.marki.mipan.model.JobAds;
import com.marki.mipan.ui.ContactFragment;

import java.util.ArrayList;

public class ManageAdapter extends RecyclerView.Adapter<ManageAdapter.MyViewHolder>  {
    private Context mContext;
    public ArrayList<String> mDataset;



    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        public Button btnText;




        public MyViewHolder(LinearLayout v) {
                super(v);
                btnText = v.findViewById(R.id.tv_title);
            }

    }
    public ManageAdapter(ArrayList<String> myDataset, Context mContext) {
        this.mDataset = myDataset;
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        LinearLayout v =  (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rec_button, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        holder.btnText.setText(mDataset.get(position));
        holder.btnText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position==0) {
                    Intent i = new Intent(mContext, CreateEvent.class);
                    i.putExtra("send",position);
                    mContext.startActivity(i);
                }else if(position==1){
                    Intent i = new Intent(mContext, SurveyCreate.class);
                    i.putExtra("send",position);
                    mContext.startActivity(i);
                }else if(position==2){
                    Intent i = new Intent(mContext, JobCreate.class);
                    i.putExtra("send",position);
                    mContext.startActivity(i);
                }else if(position==3){
                    Intent i = new Intent(mContext, ContactFragment.class);
                    i.putExtra("send",position);
                    mContext.startActivity(i);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataset.size() ;
    }



}
