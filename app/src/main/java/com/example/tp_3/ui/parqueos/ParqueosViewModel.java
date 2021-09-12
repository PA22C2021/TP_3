package com.example.tp_3.ui.parqueos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ParqueosViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ParqueosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Fragmento parqueos");
    }

    public LiveData<String> getText() {
        return mText;
    }
}