package com.example.scheduleuni.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.scheduleuni.data.FireBaseRepImpl
import com.example.scheduleuni.domain.adapters.ClassesAdapter
import com.example.scheduleuni.domain.adapters.PrepClassesAdapter
import com.example.scheduleuni.domain.models.ClassesModel
import com.example.scheduleuni.domain.models.ClassesPrepsModel
import com.example.scheduleuni.domain.usecase.GetClassesUseCase
import com.example.scheduleuni.domain.usecase.GetPrepsClassesUseCase
import java.util.*
import kotlin.collections.ArrayList

class ViewModelPrepsScheduleFragment: ViewModel() {

    private val liveDataSchedulePreps = MutableLiveData<PrepClassesAdapter>()
    val publicLiveDataSchedulePreps: LiveData<PrepClassesAdapter> = liveDataSchedulePreps


    var repository = FireBaseRepImpl()
    var dataArray = ArrayList<ClassesPrepsModel>()

    fun getScheduleForPrep(prep: String){

        var getPrepClasses = GetPrepsClassesUseCase(repository)
        var dataAdapter = PrepClassesAdapter(dataArray)
        getPrepClasses.execute(dataArray, dataAdapter, prep)
        liveDataSchedulePreps.value = dataAdapter

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