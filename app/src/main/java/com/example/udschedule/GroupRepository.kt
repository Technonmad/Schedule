package com.example.udschedule

import android.content.Context

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_GROUP_NAME = "group_name"

class GroupRepository(context: Context) : IRepository{

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun getGroup(): GroupModel {

        val groupName = sharedPreferences.getString(KEY_GROUP_NAME, "") ?: ""

        return GroupModel(groupName = groupName)
    }

}