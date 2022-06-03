package com.example.scheduleuni.domain.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.scheduleuni.R
import com.example.scheduleuni.databinding.ClassPrepItemBinding
import com.example.scheduleuni.domain.models.ClassesPrepsModel

class PrepClassesAdapter (private val classesList: ArrayList<ClassesPrepsModel>): RecyclerView.Adapter<PrepClassesAdapter.ClassHolder>() {


    class ClassHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = ClassPrepItemBinding.bind(item)
        fun bind(cl: ClassesPrepsModel) = with(binding) {
            dayofweekText.text = cl.dayofweek
            className1.text = cl.class1
            classAud1.text = cl.room1
            classGroup1.text = cl.group1
            className2.text = cl.class2
            classAud2.text = cl.room2
            classGroup2.text = cl.group2
            className3.text = cl.class3
            classAud3.text = cl.room3
            classGroup3.text = cl.group3
            className4.text = cl.class4
            classAud4.text = cl.room4
            classGroup4.text = cl.group4
            className5.text = cl.class5
            classAud5.text = cl.room5
            classGroup5.text = cl.group5
            className6.text = cl.class6
            classAud6.text = cl.room6
            classGroup6.text = cl.group6
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.class_prep_item, parent, false)
        return ClassHolder(view)
    }

    override fun onBindViewHolder(holder: ClassHolder, position: Int) {
        holder.bind(cl = classesList[position])
    }

    override fun getItemCount(): Int {
        return classesList.size
    }
}