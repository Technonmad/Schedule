package com.example.scheduleuni.presentation.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.scheduleuni.R
import com.example.scheduleuni.databinding.ActivityMainBinding
import com.example.scheduleuni.presentation.factories.MainViewModelFactory
import com.example.scheduleuni.presentation.viewmodels.ViewModelMain

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var sharedPrefFile = "sharedPrefs"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val selectedGroupSharedPreferences = this.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = selectedGroupSharedPreferences.edit()

        val directionItems = resources.getStringArray(R.array.direction_spinner)
        val directionAdapter = ArrayAdapter(this, R.layout.direction_item, directionItems)
        binding.directionSpinner.setAdapter(directionAdapter)

        val yearItems = resources.getStringArray(R.array.year_spinner)
        val yearAdapter = ArrayAdapter(this, R.layout.year_item, yearItems)
        binding.year.setAdapter(yearAdapter)

        val vm = ViewModelProvider(this, MainViewModelFactory()).get(ViewModelMain::class.java)
        val dataAdapter = ArrayAdapter(this,
            android.R.layout.simple_spinner_dropdown_item, vm.dataArray)

        val prepsAdapter = ArrayAdapter(this,
            android.R.layout.simple_spinner_dropdown_item, vm.prepsArray)

        vm.publicLiveData.observe(this) {
            binding.group.setAdapter(it)
        }

        vm.publicLiveDataPreps.observe(this) {
            binding.prepsSpinner.setAdapter(it)
        }

        vm.getPreps(prepsAdapter)

        binding.directionSpinner.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, p2, _ ->

                if (binding.year.text.toString() != ""){

                    vm.updateGroupSpinner(binding.directionSpinner, binding.year, dataAdapter)
                    binding.saveCheckbox.isEnabled = true

                }
                else{
                    binding.saveCheckbox.isEnabled = false
                    binding.group.setText("")
                    binding.group.setAdapter(null)
                }
                if (binding.directionSpinner.text.toString() == "") {
                    binding.group.setText("")
                    binding.group.setAdapter(null)
                }
                else
                    binding.saveCheckbox.isEnabled = true
                editor.putInt("direction", binding.directionSpinner.adapter.getItemId(p2).toInt())
                Log.i("dir",selectedGroupSharedPreferences.getInt("direction", 0).toString())
            }

        binding.year.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, p2, _ ->

                if (binding.directionSpinner.text.toString() != ""){

                    vm.updateGroupSpinner(binding.directionSpinner, binding.year, dataAdapter)
                    binding.saveCheckbox.isEnabled = true
                }
                else{
                    binding.saveCheckbox.isEnabled = false
                    binding.group.setText("")
                    vm.dataArray.clear()
                    binding.group.setAdapter(null)
                }
                if (binding.year.text.toString() == "") {
                    binding.group.setText("")
                    binding.group.setAdapter(null)
                }
                else
                    binding.saveCheckbox.isEnabled = true

                editor.putInt("year", binding.year.adapter.getItemId(p2).toInt())
            }

        binding.group.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, p2, _ ->
                editor.putInt("group", binding.group.adapter.getItemId(p2).toInt()) }
        
        binding.saveCheckbox.setOnCheckedChangeListener { CompoundButton, isChecked ->
            if (isChecked){
                editor.putBoolean("checkBoxState", true)
                editor.apply()
                editor.commit()
            }
            else{
                editor.clear()
                editor.apply()
                editor.commit()
            }
        }

        if (selectedGroupSharedPreferences.all.isNotEmpty()){

//            Log.i("ME", "Прошло")

            val sharedDirection = selectedGroupSharedPreferences.getInt("direction", 0)
            val sharedYear = selectedGroupSharedPreferences.getInt("year", 0)
            val sharedGroup = selectedGroupSharedPreferences.getInt("group", 0)
            binding.saveCheckbox.isEnabled = true

//            Log.i("ME", sharedDirection.toString())
//            Log.i("ME", sharedYear.toString())
//            Log.i("ME", sharedGroup.toString())
//            Log.i("ME", selectedGroupSharedPreferences.getBoolean("checkBoxState", false).toString())
//            Log.i("ME", selectedGroupSharedPreferences.all.toString())

            binding.saveCheckbox.isChecked = selectedGroupSharedPreferences.getBoolean("checkBoxState", false)

            binding.directionSpinner.setText(
                binding.directionSpinner.adapter.getItem(sharedDirection).toString(),false)
            binding.year.setText(
                binding.year.adapter.getItem(sharedYear).toString(),false)

            vm.updateGroupSpinner(binding.directionSpinner, binding.year, dataAdapter)

            val handler = Handler(Looper.myLooper()!!)
            handler.postDelayed(Runnable {
                    binding.group.setText(
                    binding.group.adapter.getItem(sharedGroup).toString(),false) }, 1500)

        }


        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
            if(binding.group.text.toString() != ""){
                val intent = Intent(this, ScheduleActivity::class.java)
                intent.putExtra("group_name", binding.group.text)
                startActivity(intent)
            }
            else
                Toast.makeText(this, "Для начала заполните поля", Toast.LENGTH_LONG).show()
        }

        val btnPrep = findViewById<Button>(R.id.btnPrep)
        btnPrep.setOnClickListener {
            if (binding.prepsSpinner.text.toString() != ""){
                val intent = Intent(this, SchedulePrepActivity::class.java)
                intent.putExtra("prep_name", binding.prepsSpinner.text)
                startActivity(intent)
            }
            else
                Toast.makeText(this, "Выберите преподавателя", Toast.LENGTH_LONG).show()
        }

    }

}