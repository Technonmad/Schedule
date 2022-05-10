package com.example.udschedule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var vm: MainViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("BRAT", "Activity created")
        vm = ViewModelProvider(this).get(MainViewModel::class.java)

        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener { Toast.makeText(this,"nice",Toast.LENGTH_SHORT).show()  }
    }
}