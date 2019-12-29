package com.marki.mipan.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.marki.mipan.R;
import com.marki.mipan.activities.FirstActivity;
import com.marki.mipan.model.Event;
import com.marki.mipan.model.Member;
import com.marki.mipan.safe.Control;
import com.marki.mipan.ui.FragmentMainActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class TypeListAdapter extends RecyclerView.Adapter<TypeListAdapter.MyViewHolder>  {
    private Context mContext;
    public ArrayList<String> mDataset;

    Member member = Member.getInstance();



    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public Button btnText;

        public MyViewHolder(LinearLayout v) {
            super(v);
            btnText = v.findViewById(R.id.tv_title);
        }
    }
    public TypeListAdapter(ArrayList<String> myDataset, Context mContext) {
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
                createGuest(mDataset.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size() ;
    }


    public void createGuest(String str) {

        //açılmamış
        String android_id = Settings.Secure.getString(mContext.getContentResolver(),
                Settings.Secure.ANDROID_ID);
        member.setUsername(android_id);
        HashMap<String,Object> myHash = new HashMap<>();
        myHash.put("create_date",System.currentTimeMillis()/1000L);
        myHash.put("has_username",true);
        myHash.put("type",str);
        myHash.put("username",member.getUsername());
        member.dbRef.child("mip")
                .child("guest")
                .child(member.getUsername())
                .setValue(myHash);

        myHash.put("username",member.getUsername());
        member.dbRef.child("mip")
                .child("guest")
                .child(member.getUsername())
                .child("open_date")
                .setValue(System.currentTimeMillis()/1000L);
        mContext.startActivity(new Intent(mContext, Control.class));

        member.setUsername(android_id);
        member.setHas_username(false);
        member.setType(str);
    }



}
