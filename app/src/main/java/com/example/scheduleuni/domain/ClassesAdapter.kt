package com.example.scheduleuni.domain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.scheduleuni.R
import com.example.scheduleuni.databinding.ClassItemBinding
import com.example.scheduleuni.domain.models.ClassesModel

class ClassesAdapter(private val classesList: ArrayList<ClassesModel>): RecyclerView.Adapter<ClassesAdapter.ClassHolder>() {


    class ClassHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = ClassItemBinding.bind(item)
        fun bind(cl: ClassesModel) = with(binding){
            dayofweekText.text = cl.dayofweek
            classAud1.text = cl.room1
            className1.text = cl.class1
            classAud2.text = cl.room2
            className2.text = cl.class2
            classAud3.text = cl.room3
            className3.text = cl.class3
            classAud4.text = cl.room4
            className4.text = cl.class4
            classAud5.text = cl.room5
            className5.text = cl.class5
            classAud6.text = cl.room6
            className6.text = cl.class6
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.class_item, parent, false)
        return ClassHolder(view)
    }

    override fun onBindViewHolder(holder: ClassHolder, position: Int) {
        holder.bind(cl = classesList[position])
    }

    override fun getItemCount(): Int {
        return classesList.size
    }

}