package com.example.scheduleuni

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.Spinner
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()


        var directionSpinner = findViewById<Spinner>(R.id.direction)
        directionSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                var db = FireBaseRepImpl(direction = directionSpinner.selectedItem.toString())
                db.getGroupsList()
                Log.i("my", directionSpinner.selectedItem.toString())
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


        var btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
            //db.getGroupsList()
            //Log.i("my", directionSpinner.selectedItem.toString())
        }

    }
}