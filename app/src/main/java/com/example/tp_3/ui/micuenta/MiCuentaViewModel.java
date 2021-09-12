package com.example.tp_3.ui.micuenta;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MiCuentaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MiCuentaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Fragmento mi cuenta");
    }

    public LiveData<String> getText() {
        return mText;
    }
}