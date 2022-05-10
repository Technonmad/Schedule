package com.example.uniDubnaSchedule;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    static {
        Log.e("BRAT", "VM started");
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
