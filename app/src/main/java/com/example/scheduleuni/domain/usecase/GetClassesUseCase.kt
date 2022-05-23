package com.example.scheduleuni.domain.usecase

import com.example.scheduleuni.domain.ClassesAdapter
import com.example.scheduleuni.domain.Repository
import com.example.scheduleuni.domain.models.ClassesModel

class GetClassesUseCase(private val repository: Repository) {

    fun execute(list: ArrayList<ClassesModel>, adapter: ClassesAdapter,
                /*param: ClassesModel, */group: String
    ){
        repository.getClasses(list = list, adapter = adapter, /*params = param, */group = group)
    }

}