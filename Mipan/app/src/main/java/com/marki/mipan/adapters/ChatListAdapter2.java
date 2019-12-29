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
import com.marki.mipan.model.Member;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ChatListAdapter2 extends RecyclerView.Adapter<ChatListAdapter2.MyViewHolder>  {
    private Context mContext;
    public ArrayList<Member> mDataset;



    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        public TextView name;

        public MyViewHolder(LinearLayout v) {
            super(v);
            name = v.findViewById(R.id.tv_fullname);
        }
    }
    public ChatListAdapter2(ArrayList<Member> myDataset, Context mContext) {
        this.mDataset = myDataset;
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public ChatListAdapter2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        LinearLayout v =  (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chat_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
      holder.name.setText(mDataset.get(position).getFull_name());
      holder.name.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String sender=mDataset.get(position).getUsername();
              Intent i=new Intent(mContext, Chat.class);
              System.out.println("zxc send"+sender);
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