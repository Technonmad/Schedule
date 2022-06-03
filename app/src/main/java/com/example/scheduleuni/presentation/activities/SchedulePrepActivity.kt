package com.example.scheduleuni.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.scheduleuni.R
import com.example.scheduleuni.databinding.ActivitySchedulePrepBinding
import com.example.scheduleuni.presentation.fragments.PeresdachiFragment
import com.example.scheduleuni.presentation.fragments.ScheduleListPrepFragment
import com.example.scheduleuni.presentation.fragments.SettingsFragment

class SchedulePrepActivity : AppCompatActivity() {

    private var bundle = Bundle()
    private lateinit var prepName:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_prep)

        prepName = intent.extras?.get("prep_name").toString()

        val binding = ActivitySchedulePrepBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.navigation.setOnItemSelectedListener {
            when (it.itemId){
                R.id.schedule_item -> {loadFragment(ScheduleListPrepFragment())}
                R.id.settings_item -> {loadFragment(SettingsFragment())}
                R.id.peresdachi_item -> {loadFragment(PeresdachiFragment())}
            }

            true
        }
    }

    override fun onStart() {
        super.onStart()
        loadFragment(ScheduleListPrepFragment())
    }

    private fun loadFragment(fragment: Fragment) {

        bundle.putString("prep_name", prepName)
        //Log.i("MY", bundle.toString())
        fragment.arguments = bundle

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}