package com.example.scheduleuni.presentation.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.scheduleuni.R
import com.example.scheduleuni.databinding.FragmentScheduleListBinding
import com.example.scheduleuni.databinding.FragmentSchedulePrepBinding
import com.example.scheduleuni.presentation.factories.ScheduleFragmentViewModelFactory
import com.example.scheduleuni.presentation.factories.SchedulePrepsFragmentVMFactory
import com.example.scheduleuni.presentation.viewmodels.ViewModelPrepsScheduleFragment
import com.example.scheduleuni.presentation.viewmodels.ViewModelScheduleFragment

class ScheduleListPrepFragment : Fragment() {

    private var _binding: FragmentSchedulePrepBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val data = arguments
        _binding = FragmentSchedulePrepBinding.inflate(inflater, container, false)
        val view = binding.root

        val vm = ViewModelProvider(this, SchedulePrepsFragmentVMFactory()).get(
            ViewModelPrepsScheduleFragment::class.java)
        vm.publicLiveDataSchedulePreps.observe(viewLifecycleOwner, Observer {
            binding.classesPrepRec.adapter = it
        })
        binding.apply {
            classesPrepRec.layoutManager = LinearLayoutManager(this@ScheduleListPrepFragment.context)
            vm.getScheduleForPrep(data!!.get("prep_name").toString())
        }

        binding.prepName.text = " " + data!!.get("prep_name").toString()
        binding.currentWeek.text = " " + vm.getCurrentWeek()
        return view
    }

}