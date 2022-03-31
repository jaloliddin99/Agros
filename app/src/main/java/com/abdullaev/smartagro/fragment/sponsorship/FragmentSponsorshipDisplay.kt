package com.abdullaev.smartagro.fragment.sponsorship

import android.R
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.view.ContextThemeWrapper
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.abdullaev.smartagro.databinding.FragmentSponsorshipDisplayBinding
import com.abdullaev.smartagro.utils.statusBarColor

class FragmentSponsorshipDisplay:Fragment() {

    private val args:FragmentSponsorshipDisplayArgs by navArgs()
    private lateinit var binding: FragmentSponsorshipDisplayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition =
            com.google.android.material.transition.MaterialContainerTransform()
                .apply {
                    this.containerColor = Color.TRANSPARENT
                    this.startContainerColor = Color.TRANSPARENT
                    duration = 250.toLong()
                    scrimColor = Color.TRANSPARENT

                }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val contextThemeWrapper: Context = ContextThemeWrapper(
            activity,
            R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen
        )
        val localInflater = inflater.cloneInContext(contextThemeWrapper)
        return localInflater.inflate(com.abdullaev.smartagro.R.layout.fragment_sponsorship_display, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val newsViewBinding=FragmentSponsorshipDisplayBinding.bind(view)
        binding=newsViewBinding
        binding.apply {
            if (args.isFirst) {
                mainView.transitionName="cardViewTransition${args.transitionName}"
            }else{
                mainView.transitionName="cardViewTransition${args.transitionName}${args.transitionName}"
            }
        }
        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

    }

    override fun onStop() {
        super.onStop()
        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }

    override fun onDetach() {
        super.onDetach()
        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)


    }
}