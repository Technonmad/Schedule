package com.example.scheduleuni.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import com.example.scheduleuni.R
import com.example.scheduleuni.data.FireBaseRepImpl
import com.example.scheduleuni.domain.models.GroupData
import com.example.scheduleuni.domain.usecase.GetGroupsUseCase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var repository = FireBaseRepImpl()
        var yearSpinner = findViewById<Spinner>(R.id.year)
        var directionSpinner = findViewById<Spinner>(R.id.direction)
        var groupSpinner = findViewById<Spinner>(R.id.group)
        var dataArray = ArrayList<String>()
        val dataAdapter = ArrayAdapter<String>(applicationContext,android.R.layout.simple_spinner_dropdown_item, dataArray)

        fun updateGroupSpinner(spinner_direction: Spinner, spinner_year:Spinner){
            var getGroups = GetGroupsUseCase(repository)
            var param = GroupData(spinner_direction.selectedItem.toString(), spinner_year.selectedItem.toString())
            getGroups.execute(dataArray, dataAdapter, param)
            groupSpinner.adapter = dataAdapter
        }


        yearSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                updateGroupSpinner(directionSpinner,yearSpinner)
                Log.i("ME", "TATA")
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        directionSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                updateGroupSpinner(directionSpinner,yearSpinner)
                Log.i("ME", "TATA")
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


        var btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
            val intent = Intent(this, ScheduleActivity::class.java)
            startActivity(intent)
        }

    }

}