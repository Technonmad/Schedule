package com.example.scheduleuni.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.scheduleuni.R
import com.example.scheduleuni.databinding.ActivityScheduleBinding

class ScheduleActivity : AppCompatActivity() {

    lateinit var binding: ActivityScheduleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.navigation.setOnItemSelectedListener {
            when (it.itemId){
                R.id.schedule_item -> {loadFragment(ScheduleListFragment())}
                R.id.tasks_item -> {loadFragment(TasksFragment())}
            }
            true
        }
    }

    override fun onStart() {
        super.onStart()
        loadFragment(ScheduleListFragment())
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

}