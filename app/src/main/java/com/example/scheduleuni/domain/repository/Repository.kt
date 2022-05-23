package com.example.scheduleuni.domain.repository

import android.widget.ArrayAdapter
import com.example.scheduleuni.domain.adapters.ClassesAdapter
import com.example.scheduleuni.domain.models.ClassesModel
import com.example.scheduleuni.domain.models.GroupData

interface Repository {

    fun getGroupsList(list: ArrayList<String>, adapter: ArrayAdapter<String>,
                      params: GroupData)

    fun getClasses(list: ArrayList<ClassesModel>, adapter: ClassesAdapter, group: String)
}