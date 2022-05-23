package com.example.scheduleuni.presentation.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.scheduleuni.R
import com.example.scheduleuni.databinding.ActivityMainBinding
import com.example.scheduleuni.presentation.factories.MainViewModelFactory
import com.example.scheduleuni.presentation.viewmodels.ViewModelMain

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var direction_items = resources.getStringArray(R.array.direction_spinner)
        var directionAdapter = ArrayAdapter(this, R.layout.direction_item, direction_items)
        binding.directionSpinner.setAdapter(directionAdapter)

        var year_items = resources.getStringArray(R.array.year_spinner)
        var yearAdapter = ArrayAdapter(this, R.layout.year_item, year_items)
        binding.year.setAdapter(yearAdapter)

        val vm = ViewModelProvider(this, MainViewModelFactory()).get(ViewModelMain::class.java)
        val dataAdapter = ArrayAdapter(this,
            android.R.layout.simple_spinner_dropdown_item, vm.dataArray)

        vm.publicLiveData.observe(this, Observer {
            binding.group.setAdapter(it)
        })

        binding.directionSpinner.onItemClickListener = object :AdapterView.OnItemClickListener{

            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if (binding.year.text != null)
                    vm.updateGroupSpinner(binding.directionSpinner, binding.year, dataAdapter)
            }
        }

        binding.year.onItemClickListener = object : AdapterView.OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if (binding.directionSpinner.text != null)
                    vm.updateGroupSpinner(binding.directionSpinner, binding.year, dataAdapter)
            }
        }


        var btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
            val intent = Intent(this, ScheduleActivity::class.java)
            intent.putExtra("group_name", binding.group.text)
            //Log.i("MY", binding.group.selectedItem.toString())
            startActivity(intent)
        }

    }

}