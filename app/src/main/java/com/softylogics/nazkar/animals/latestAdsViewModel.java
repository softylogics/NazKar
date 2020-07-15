package com.softylogics.nazkar.animals;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class latestAdsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public latestAdsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is mask fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}