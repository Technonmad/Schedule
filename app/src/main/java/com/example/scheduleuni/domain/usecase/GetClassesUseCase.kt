package com.example.scheduleuni.domain.usecase

import android.widget.ArrayAdapter
import com.example.scheduleuni.domain.Repository
import com.example.scheduleuni.domain.models.ClassModel

class GetClassesUseCase(private val repository: Repository) {

    fun execute(list: ArrayList<String>, adapter: ArrayAdapter<String>,
                param: ClassModel
    ){
        repository.getClasses(list = list, adapter = adapter, params = param)
    }

}