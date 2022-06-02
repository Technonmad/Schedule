package com.example.scheduleuni.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.scheduleuni.data.FireBaseRepImpl
import com.example.scheduleuni.domain.adapters.ClassesAdapter
import com.example.scheduleuni.domain.models.ClassesModel
import com.example.scheduleuni.domain.usecase.GetClassesUseCase
import java.util.*
import kotlin.collections.ArrayList

class ViewModelScheduleFragment: ViewModel() {

    private val liveDataSchedule = MutableLiveData<ClassesAdapter>()
    val publicLiveDataSchedule: LiveData<ClassesAdapter> = liveDataSchedule


    var repository = FireBaseRepImpl()
    var dataArray = ArrayList<ClassesModel>()

    fun getScheduleForGroup(group: String){

        var getClasses = GetClassesUseCase(repository)
        var dataAdapter = ClassesAdapter(dataArray)
        getClasses.execute(dataArray, dataAdapter, group)
        liveDataSchedule.value = dataAdapter

    }

    fun getCurrentWeek() : String{
        var week = Calendar.getInstance(TimeZone.getTimeZone("GMT+3")).get(Calendar.WEEK_OF_YEAR)
        var weekName : String
        if (week / 2 == 0)
            weekName = "/ Четная"
        else weekName = "Нечетная /"
        //Log.i("Week", week.toString())
        return weekName
    }

}