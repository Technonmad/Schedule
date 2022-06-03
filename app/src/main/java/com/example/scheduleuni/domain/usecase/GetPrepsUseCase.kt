package com.example.scheduleuni.domain.usecase

import android.widget.ArrayAdapter
import com.example.scheduleuni.domain.repository.Repository

class GetPrepsUseCase (private val repository: Repository) {
    fun execute(list: ArrayList<String>, adapter: ArrayAdapter<String>){
        repository.getPreps(list = list, adapter = adapter)
    }
}