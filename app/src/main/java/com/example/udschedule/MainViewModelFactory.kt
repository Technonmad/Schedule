package com.example.udschedule

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModel

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel() as T
    }

}