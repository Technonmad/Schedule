package com.example.scheduleuni.presentation.viewmodels

import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.scheduleuni.data.FireBaseRepImpl
import com.example.scheduleuni.domain.models.GroupModel
import com.example.scheduleuni.domain.usecase.GetGroupsUseCase
import com.example.scheduleuni.domain.usecase.GetPrepsUseCase

class ViewModelMain: ViewModel() {


    private val liveData = MutableLiveData<ArrayAdapter<String>>()
    var publicLiveData: LiveData<ArrayAdapter<String>> = liveData

    private val liveDataPreps = MutableLiveData<ArrayAdapter<String>>()
    var publicLiveDataPreps: LiveData<ArrayAdapter<String>> = liveDataPreps


    var repository = FireBaseRepImpl()
    var dataArray = ArrayList<String>()
    var prepsArray = ArrayList<String>()

    fun updateGroupSpinner(spinner_direction: AutoCompleteTextView, spinner_year: AutoCompleteTextView, dataAdapter: ArrayAdapter<String>) {
        var getGroups = GetGroupsUseCase(repository)
        var param = GroupModel(spinner_direction.text.toString(), spinner_year.text.toString())
        getGroups.execute(dataArray, dataAdapter, param)
        liveData.value = dataAdapter
    }

    fun getPreps(adapter: ArrayAdapter<String>){
        var getPreps = GetPrepsUseCase(repository)
        getPreps.execute(list = prepsArray, adapter = adapter)
        liveDataPreps.value = adapter
    }
}