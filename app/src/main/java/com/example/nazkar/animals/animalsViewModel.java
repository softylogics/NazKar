package com.example.nazkar.animals;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class animalsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public animalsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is mask fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}