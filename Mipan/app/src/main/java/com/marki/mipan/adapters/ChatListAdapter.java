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

import com.google.android.material.chip.ChipGroup;
import com.marki.mipan.R;
import com.marki.mipan.activities.Chat;
import com.marki.mipan.model.Event;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.MyViewHolder>  {
    private Context mContext;
    public ArrayList<String> mDataset;



    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        public TextView name;
        public ImageView imageView;

        public MyViewHolder(LinearLayout v) {
            super(v);

            name = v.findViewById(R.id.tv_fullname);
            imageView=v.findViewById(R.id.img_profil_photo);
        }
    }
    public ChatListAdapter(ArrayList<String> myDataset, Context mContext) {
        this.mDataset = myDataset;
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public ChatListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        LinearLayout v =  (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chat_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
      holder.name.setText(mDataset.get(position));
      Picasso.with(mContext).load("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQIvHK9drwIxHHQq6_hHRa2W4wKy8zs9OPhIWdpK_9-qZpE5AtS").into(holder.imageView);
      holder.name.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String sender=mDataset.get(position);
              Intent i=new Intent(mContext, Chat.class);
              i.putExtra("sender",sender);
              mContext.startActivity(i);
          }
      });
    }

    @Override
    public int getItemCount() {
        return mDataset.size() ;
    }



}