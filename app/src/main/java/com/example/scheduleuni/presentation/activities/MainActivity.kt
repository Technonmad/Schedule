package com.example.scheduleuni.presentation.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.lifecycle.ViewModelProvider
import com.example.scheduleuni.R
import com.example.scheduleuni.data.FireBaseRepImpl
import com.example.scheduleuni.databinding.ActivityMainBinding
import com.example.scheduleuni.domain.models.GroupData
import com.example.scheduleuni.domain.usecase.GetGroupsUseCase
import com.example.scheduleuni.presentation.ViewModelMain

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val vm = ViewModelProvider(this).get(ViewModelMain::class.java)
        val dataAdapter = ArrayAdapter<String>(applicationContext,
            android.R.layout.simple_spinner_dropdown_item, vm.dataArray)

        binding.year.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                binding.group.adapter = vm.updateGroupSpinner(binding.direction, binding.year, dataAdapter)

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        binding.direction.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                binding.group.adapter = vm.updateGroupSpinner(binding.direction, binding.year, dataAdapter)

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