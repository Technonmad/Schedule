package com.example.scheduleuni.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.scheduleuni.databinding.FragmentScheduleListBinding
import com.example.scheduleuni.domain.ClassesAdapter
import com.example.scheduleuni.domain.models.ClassModel


class ScheduleListFragment : Fragment() {

    private var _binding: FragmentScheduleListBinding? = null
    private val binding get() = _binding!!
    private val adapter_classes = ClassesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentScheduleListBinding.inflate(inflater, container, false)
        val view = binding.root
        init()
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun init() {
        binding.apply {
            classesRec.layoutManager = LinearLayoutManager(this@ScheduleListFragment.context)
            classesRec.adapter = adapter_classes
            val cl = ClassModel(
                dayofweek = "Тяжелый день",
                auditory = "1-415",
                cl_name = "Очень важная пара",
                prim = "Переделывай")
            adapter_classes.addClass(cl)
        }
    }

}