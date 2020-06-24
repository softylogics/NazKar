package com.softylogics.nazkar.animals;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

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