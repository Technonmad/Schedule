package com.example.scheduleuni.domain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.scheduleuni.R
import com.example.scheduleuni.databinding.ClassItemBinding
import com.example.scheduleuni.domain.models.ClassModel

class ClassesAdapter: RecyclerView.Adapter<ClassesAdapter.ClassHolder>() {

    private val classList = ArrayList<ClassModel>()

    class ClassHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = ClassItemBinding.bind(item)
        fun bind(cl: ClassModel) = with(binding){
            dayofweekText.text = cl.dayofweek
            classAud.text = cl.auditory
            className.text = cl.cl_name
            classPrim.text = cl.prim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.class_item, parent, false)
        return ClassHolder(view)
    }

    override fun onBindViewHolder(holder: ClassHolder, position: Int) {
        holder.bind(cl = classList[position])
    }

    override fun getItemCount(): Int {
        return classList.size
    }

    fun addClass(cl: ClassModel) {
        classList.add(cl)
        notifyDataSetChanged()
    }
}