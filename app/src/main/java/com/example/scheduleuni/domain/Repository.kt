package com.example.scheduleuni.domain

import android.widget.ArrayAdapter
import com.example.scheduleuni.domain.models.GroupData

interface Repository {

    fun getGroupsList(list: ArrayList<String>, adapter: ArrayAdapter<String>,
                      params: GroupData)

    fun getClasses()

}