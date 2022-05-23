package com.example.scheduleuni.domain.usecase

import android.widget.ArrayAdapter
import com.example.scheduleuni.domain.Repository
import com.example.scheduleuni.domain.models.GroupData

class GetGroupsUseCase(private val repository: Repository) {

    fun execute(list: ArrayList<String>, adapter: ArrayAdapter<String>, param: GroupData){
        repository.getGroupsList(list = list, adapter = adapter, params = param)
    }

}