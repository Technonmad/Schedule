package com.example.scheduleuni.presentation.viewmodels

import android.R
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.scheduleuni.data.FireBaseRepImpl
import com.example.scheduleuni.domain.models.GroupData
import com.example.scheduleuni.domain.usecase.GetGroupsUseCase

class ViewModelMain: ViewModel() {


    private val liveData = MutableLiveData<ArrayAdapter<String>>()
    val publicLiveData: LiveData<ArrayAdapter<String>> = liveData


    var repository = FireBaseRepImpl()
    var dataArray = ArrayList<String>()

    fun updateGroupSpinner(spinner_direction: Spinner, spinner_year: Spinner, dataAdapter: ArrayAdapter<String>) {
        var getGroups = GetGroupsUseCase(repository)
        var param = GroupData(spinner_direction.selectedItem.toString(), spinner_year.selectedItem.toString())
        getGroups.execute(dataArray, dataAdapter, param)
        liveData.value = dataAdapter
    }

}