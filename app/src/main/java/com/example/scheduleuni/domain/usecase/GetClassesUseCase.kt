package com.example.scheduleuni.domain.usecase

import com.example.scheduleuni.domain.adapters.ClassesAdapter
import com.example.scheduleuni.domain.repository.Repository
import com.example.scheduleuni.domain.models.ClassesModel

class GetClassesUseCase(private val repository: Repository) {

    fun execute(list: ArrayList<ClassesModel>, adapter: ClassesAdapter, group: String){
        repository.getClasses(list = list, adapter = adapter, group = group)
    }

}