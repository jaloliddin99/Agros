package com.abdullaev.smartagro.fragment.marketplace

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.abdullaev.smartagro.databinding.FragmentPodcastDisplayBinding
import com.abdullaev.smartagro.model.TestModel
import com.google.android.material.transition.MaterialContainerTransform

class FragmentPodcastDisplay : Fragment(){
    private lateinit var sportsArgs: TestModel

    var binding: FragmentPodcastDisplayBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = requireArguments()
        sportsArgs = FragmentPodcastDisplayArgs.fromBundle(args).testModel
        sharedElementEnterTransition = MaterialContainerTransform().apply {

            duration = 300.toLong()
            scrimColor = Color.TRANSPARENT

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentPodcastDisplayBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            backToHome.setOnClickListener {
                findNavController().popBackStack()
            }

            binding?.apply {
                imageView.setImageResource(sportsArgs.image)
                testView.text = sportsArgs.title
                testView.transitionName=sportsArgs.titleId

                constraint.transitionName = sportsArgs.title
            }


        }
    }

}