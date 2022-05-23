package com.example.scheduleuni.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.scheduleuni.data.FireBaseRepImpl
import com.example.scheduleuni.domain.ClassesAdapter
import com.example.scheduleuni.domain.models.ClassesModel
import com.example.scheduleuni.domain.usecase.GetClassesUseCase

class ViewModelScheduleFragment: ViewModel() {

    private val liveData = MutableLiveData<ClassesAdapter>()
    val publicLiveData: LiveData<ClassesAdapter> = liveData


    var repository = FireBaseRepImpl()
    var dataArray = ArrayList<ClassesModel>()

    fun getScheduleForGroup(/*cl: ClassesModel, */dataAdapter: ClassesAdapter){

        var getClasses = GetClassesUseCase(repository)
        //var classes_data = cl
        getClasses.execute(dataArray, dataAdapter, /*cl, */"1011")
        liveData.value = dataAdapter

    }

    /*fun updateGroupSpinner(spinner_direction: Spinner, spinner_year: Spinner, dataAdapter: ArrayAdapter<String>) {
        var getGroups = GetGroupsUseCase(repository)
        var param = GroupData(spinner_direction.selectedItem.toString(), spinner_year.selectedItem.toString())
        getGroups.execute(dataArray, dataAdapter, param)
        liveData.value = dataAdapter
    }*/

}