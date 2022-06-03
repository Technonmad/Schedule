package com.example.scheduleuni.domain.usecase

import android.widget.ArrayAdapter
import com.example.scheduleuni.domain.repository.Repository
import com.example.scheduleuni.domain.models.GroupModel

class GetGroupsUseCase(private val repository: Repository) {

    fun execute(list: ArrayList<String>, adapter: ArrayAdapter<String>, param: GroupModel){
        repository.getGroupsList(list = list, adapter = adapter, params = param)
    }

}