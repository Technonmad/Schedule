package com.example.scheduleuni.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.scheduleuni.data.FireBaseRepImpl
import com.example.scheduleuni.domain.adapters.ClassesAdapter
import com.example.scheduleuni.domain.models.ClassesModel
import com.example.scheduleuni.domain.usecase.GetClassesUseCase

class ViewModelScheduleFragment: ViewModel() {

    private val liveData = MutableLiveData<ClassesAdapter>()
    val publicLiveData: LiveData<ClassesAdapter> = liveData


    var repository = FireBaseRepImpl()
    var dataArray = ArrayList<ClassesModel>()

    fun getScheduleForGroup(group: String){

        var getClasses = GetClassesUseCase(repository)
        var dataAdapter = ClassesAdapter(dataArray)
        getClasses.execute(dataArray, dataAdapter, group)
        liveData.value = dataAdapter

    }

}