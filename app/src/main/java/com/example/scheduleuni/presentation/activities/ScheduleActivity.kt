package com.example.scheduleuni.presentation.activities

import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.scheduleuni.R
import com.example.scheduleuni.databinding.ActivityScheduleBinding
import com.example.scheduleuni.presentation.fragments.ScheduleListFragment
import com.example.scheduleuni.presentation.fragments.SettingsFragment
import com.example.scheduleuni.presentation.fragments.TasksFragment

class ScheduleActivity : AppCompatActivity() {

    private var bundle = Bundle()
    var group = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        group = intent.extras?.get("group_name").toString()

        val binding = ActivityScheduleBinding.inflate(layoutInflater)
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
        bundle.putString("group_name", group)
        //Log.i("MY", bundle.toString())
        fragment.arguments = bundle

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

}