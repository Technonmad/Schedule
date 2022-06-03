package com.example.scheduleuni.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.scheduleuni.R
import com.example.scheduleuni.databinding.ActivitySchedulePrepBinding
import com.example.scheduleuni.presentation.fragments.ScheduleListPrepFragment
import com.example.scheduleuni.presentation.fragments.SettingsFragment

class SchedulePrepActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_prep)

        val binding = ActivitySchedulePrepBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.navigation.setOnItemSelectedListener {
            when (it.itemId){
                R.id.schedule_item -> {loadFragment(ScheduleListPrepFragment())}
                R.id.settings_item -> {loadFragment(SettingsFragment())}
            }

            true
        }
    }

    override fun onStart() {
        super.onStart()
        loadFragment(ScheduleListPrepFragment())
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}