package com.example.scheduleuni.data

import android.widget.ArrayAdapter
import com.example.scheduleuni.domain.Repository
import com.example.scheduleuni.domain.models.GroupData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FireBaseRepImpl : Repository {

    private val database = Firebase.database

    override fun getGroupsList(list: ArrayList<String>, adapter: ArrayAdapter<String>,
                               params: GroupData) {

        val ref = database.getReference("Groups").child(params.direction).child(params.year)

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


    override fun getClasses() {
        TODO("Not yet implemented")
    }

}