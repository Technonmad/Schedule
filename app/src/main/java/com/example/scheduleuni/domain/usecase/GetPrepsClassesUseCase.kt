package com.example.scheduleuni.domain.usecase

import com.example.scheduleuni.domain.adapters.ClassesAdapter
import com.example.scheduleuni.domain.adapters.PrepClassesAdapter
import com.example.scheduleuni.domain.models.ClassesModel
import com.example.scheduleuni.domain.models.ClassesPrepsModel
import com.example.scheduleuni.domain.repository.Repository

class GetPrepsClassesUseCase(private val repository: Repository) {
    fun execute(list: ArrayList<ClassesPrepsModel>, adapter: PrepClassesAdapter, prep: String){
        repository.getPrepClasses(list = list, adapter = adapter, prep = prep)
    }
}