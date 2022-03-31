package com.abdullaev.smartagro.fragment.manegement

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.transition.Slide
import com.abdullaev.smartagro.R
import com.abdullaev.smartagro.databinding.FragmentColloborationBinding
import com.abdullaev.smartagro.databinding.FragmentFarmManagementBinding
import com.google.android.material.transition.MaterialContainerTransform

class FragmentFarmManagement : Fragment(){

    private lateinit var binding: FragmentFarmManagementBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentFarmManagementBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        enterTransition = MaterialContainerTransform().apply {
            startView = requireActivity().findViewById(R.id.fab)
            endView = binding.coordinator
            duration = resources.getInteger(R.integer.reply_motion_duration_large).toLong()
            scrimColor = Color.TRANSPARENT

        }
        returnTransition = Slide().apply {
            duration = resources.getInteger(R.integer.reply_motion_duration_medium).toLong()
            addTarget(R.id.coordinator)
        }
    }
}