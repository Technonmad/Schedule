package com.example.scheduleuni.domain.repository

import android.widget.ArrayAdapter
import com.example.scheduleuni.domain.adapters.ClassesAdapter
import com.example.scheduleuni.domain.adapters.PrepClassesAdapter
import com.example.scheduleuni.domain.models.ClassesModel
import com.example.scheduleuni.domain.models.ClassesPrepsModel
import com.example.scheduleuni.domain.models.GroupModel

interface Repository {

    fun getGroupsList(list: ArrayList<String>, adapter: ArrayAdapter<String>,
                      params: GroupModel)

    fun getClasses(list: ArrayList<ClassesModel>, adapter: ClassesAdapter, group: String)

    fun getPreps(list: ArrayList<String>, adapter: ArrayAdapter<String>)

    fun getPrepClasses(list: ArrayList<ClassesPrepsModel>, adapter: PrepClassesAdapter, prep: String)
}