package com.example.scheduleuni.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.scheduleuni.databinding.FragmentScheduleListBinding
import com.example.scheduleuni.presentation.factories.ScheduleFragmentViewModelFactory
import com.example.scheduleuni.presentation.viewmodels.ViewModelScheduleFragment


class ScheduleListFragment : Fragment() {

    private var _binding: FragmentScheduleListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentScheduleListBinding.inflate(inflater, container, false)
        val view = binding.root
        val vm = ViewModelProvider(this, ScheduleFragmentViewModelFactory()).get(ViewModelScheduleFragment::class.java)
        vm.publicLiveDataSchedule.observe(viewLifecycleOwner, Observer {
            binding.classesRec.adapter = it
        })
        binding.apply {
            classesRec.layoutManager = LinearLayoutManager(this@ScheduleListFragment.context)
            vm.getScheduleForGroup()
        }
        val data = arguments
        binding.currentGroup.text = " " + data!!.get("group_name").toString()
        binding.currentWeek.text = " " + vm.getCurrentWeek()
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}