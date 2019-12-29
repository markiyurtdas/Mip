package com.marki.mipan.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.marki.mipan.R;
import com.marki.mipan.model.Event;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class EventFragmentAdapter2 extends RecyclerView.Adapter<EventFragmentAdapter2.MyViewHolder>  {
    private Context mContext;
    public ArrayList<Event> mDataset;



    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView imageView;
        ;
        public TextView tvTitle;
        public TextView tvDescription;

        public MyViewHolder(LinearLayout v) {
            super(v);
            imageView = v.findViewById(R.id.img_home);
            tvTitle = v.findViewById(R.id.tv_title);
            tvDescription = v.findViewById(R.id.tv_desc);
        }
    }
    public EventFragmentAdapter2(ArrayList<Event> myDataset, Context mContext) {
        this.mDataset = myDataset;
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        LinearLayout v =  (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rec_event, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        Event e = mDataset.get(position);
        if (e.getPhoto()!= null){
            try{
                Picasso.with(mContext).load(e.getPhoto()).into(holder.imageView);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        holder.tvTitle.setText(e.getTitle());
        holder.tvDescription.setText(e.getDescription());
    }

    @Override
    public int getItemCount() {
        return mDataset.size() ;
    }



}
