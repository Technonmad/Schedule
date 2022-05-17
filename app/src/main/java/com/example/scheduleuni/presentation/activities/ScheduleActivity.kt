package com.example.scheduleuni.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.scheduleuni.R
import com.example.scheduleuni.databinding.ActivityScheduleBinding
import com.example.scheduleuni.presentation.fragments.ScheduleListFragment

import com.example.scheduleuni.presentation.TasksFragment
import com.example.scheduleuni.presentation.fragments.SettingsFragment

class ScheduleActivity : AppCompatActivity() {

    lateinit var binding : ActivityScheduleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.navigation.setOnItemSelectedListener {
            when (it.itemId){
                R.id.schedule_item -> {loadFragment(ScheduleListFragment())}
                R.id.tasks_item -> {loadFragment(TasksFragment())}
                R.id.settings_item -> {loadFragment(SettingsFragment())}
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