package com.example.scheduleuni.data

import android.widget.ArrayAdapter
import com.example.scheduleuni.domain.adapters.ClassesAdapter
import com.example.scheduleuni.domain.repository.Repository
import com.example.scheduleuni.domain.models.ClassesModel
import com.example.scheduleuni.domain.models.GroupData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FireBaseRepImpl : Repository {

    private val database = Firebase.database

    override fun getGroupsList(list: ArrayList<String>, adapter: ArrayAdapter<String>,
                               params: GroupData) {

        val ref = database.getReference("Groups").child(params.direction).child(params.year)

        listener(ref, list, adapter)
    }


    override fun getClasses(list: ArrayList<ClassesModel>, adapter: ClassesAdapter, group: String) {

        val day = database.getReference("Schedule").child(group).orderByChild("sortKey")

        day.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                list.clear()
                for (mydata: DataSnapshot in snapshot.children){
                    val classes = mydata.getValue(ClassesModel::class.java)
                    list.add(classes!!)
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun listener(ref: DatabaseReference, list: ArrayList<String>, adapter: ArrayAdapter<String> ){

        ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                list.clear()
                for (mydata: DataSnapshot in snapshot.children)
                    list.add(mydata.value.toString())
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

}