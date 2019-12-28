package com.marki.mipan.ui.home;

import android.os.Handler;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<ArrayList<String>> mDataset;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
    public LiveData<ArrayList<String>> getMDataset() {
        if (mDataset == null) {
            mDataset = new MutableLiveData<>();
            loadEvents();
        }
        return mDataset;
    }


    private void loadEvents() {
        // do async operation to fetch users
        Handler myHandler = new Handler();
        myHandler.postDelayed(() -> {
            ArrayList<String> mSet = new ArrayList<>();
            mSet.add("Mango");
            mSet.add("Apple");
            mSet.add("Orange");
            mSet.add("Banana");
            mSet.add("Grapes");


            mDataset.setValue(mSet);
        }, 0);

    }


    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("HomeViewModel", "on cleared called");
    }
}