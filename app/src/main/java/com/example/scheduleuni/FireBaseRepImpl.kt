package com.example.scheduleuni

import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FireBaseRepImpl(direction: String): Repository {

    private val database = Firebase.database
    private val ref = database.getReference("Groups").child(direction).child("1 курс").child("group").get()
   // private lateinit var db: DatabaseReference


    override fun getGroupsList() {
        //db = Firebase.database.reference
        ref.addOnSuccessListener {
            Log.i("firebase", "${it.value}")
        }.addOnFailureListener{
            Log.e("firebase", "Error getting data", it)
        }
    }

    override fun getClasses() {
        TODO("Not yet implemented")
    }

}