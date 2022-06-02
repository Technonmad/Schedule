package com.example.scheduleuni.presentation.viewmodels

import android.content.Context
import android.content.SharedPreferences
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.CheckBox
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.scheduleuni.data.FireBaseRepImpl
import com.example.scheduleuni.domain.models.GroupData
import com.example.scheduleuni.domain.usecase.GetGroupsUseCase

class ViewModelMain: ViewModel() {


    private val liveData = MutableLiveData<ArrayAdapter<String>>()
    var publicLiveData: LiveData<ArrayAdapter<String>> = liveData


    var repository = FireBaseRepImpl()
    var dataArray = ArrayList<String>()

    fun updateGroupSpinner(spinner_direction: AutoCompleteTextView, spinner_year: AutoCompleteTextView, dataAdapter: ArrayAdapter<String>) {
        var getGroups = GetGroupsUseCase(repository)
        var param = GroupData(spinner_direction.text.toString(), spinner_year.text.toString())
        getGroups.execute(dataArray, dataAdapter, param)
        liveData.value = dataAdapter
    }
}