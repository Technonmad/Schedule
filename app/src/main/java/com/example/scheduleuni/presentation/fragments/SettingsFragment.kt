package com.example.scheduleuni.presentation.fragments

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.scheduleuni.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}