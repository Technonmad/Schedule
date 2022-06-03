package com.example.scheduleuni.presentation.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.scheduleuni.presentation.viewmodels.ViewModelPrepsScheduleFragment

class SchedulePrepsFragmentVMFactory: ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ViewModelPrepsScheduleFragment() as T
    }

}