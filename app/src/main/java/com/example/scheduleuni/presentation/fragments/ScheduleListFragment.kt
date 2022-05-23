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
import com.example.scheduleuni.domain.ClassesAdapter
import com.example.scheduleuni.domain.models.ClassesModel
import com.example.scheduleuni.presentation.factories.ScheduleFragmentViewModelFactory
import com.example.scheduleuni.presentation.viewmodels.ViewModelScheduleFragment


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
        val vm = ViewModelProvider(this, ScheduleFragmentViewModelFactory()).get(ViewModelScheduleFragment::class.java)
        //init()
        vm.publicLiveData.observe(viewLifecycleOwner, Observer {
            binding.classesRec.adapter = it
        })
        binding.apply {
            classesRec.layoutManager = LinearLayoutManager(this@ScheduleListFragment.context)
            /*val cl = ClassesModel(
                //group = "",
                dayofweek = "Тяжелый день",
                // = arguments?.get("group_name").toString(),
                cl_name = "Очень важная пара",
                prim = "Переделывай")*/
            vm.getScheduleForGroup(/*cl, */adapter_classes)
            classesRec.adapter = adapter_classes
            //adapter_classes.addClass(cl)
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

//    private fun init() {
//        val vm = ViewModelProvider(this, /*ViewModelFactory()*/).get(ViewModelScheduleFragment::class.java)
//        binding.apply {
//            classesRec.layoutManager = LinearLayoutManager(this@ScheduleListFragment.context)
//            classesRec.adapter = adapter_classes
//            val cl = ClassesModel(
//                //group = "",
//                dayofweek = "Тяжелый день",
//                auditory = arguments?.get("group_name").toString(),
//                cl_name = "Очень важная пара",
//                prim = "Переделывай")
//            vm.getScheduleForGroup(cl, adapter_classes)
//            //adapter_classes.addClass(cl)
//        }
//    }

}