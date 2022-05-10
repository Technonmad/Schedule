package com.example.udschedule

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    init {
        Log.e("BRAT", "VIEW MODEL STARTED");
    }

    override fun onCleared() {
        Log.e("BRAT", "VIEW MODEL DIED");
        super.onCleared()
    }



}