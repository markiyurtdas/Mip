package com.marki.mipan.ui;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.marki.mipan.R;

import java.util.ArrayList;
import java.util.List;

public class ContactFragment extends Fragment {

    private Spinner spinnerCall;
    private TextView tv_number,tv_number1,tv_number2;
    Button btnCall,btnMessages;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_contact, container, false);

        spinnerCall=root.findViewById(R.id.spinner_emergency_number);
        btnCall=root.findViewById(R.id.btn_call);
        btnMessages=root.findViewById(R.id.btn_messages);

        List<String> list=new ArrayList<>();
        list.add("55");
        list.add("22");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                R.layout.spinner_item_emergency, list);

        adapter.setDropDownViewResource(R.layout.spinner_item_emergency);

        spinnerCall.setAdapter(adapter);
        spinnerCall.setSelection(0);
        spinnerCall.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                btnCall.setText(list.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return root;
    }
}