package com.abdullaev.smartagro.fragment.boarding

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.abdullaev.smartagro.MainActivity
import com.abdullaev.smartagro.R
import com.abdullaev.smartagro.adapter.FragmentQuestionPagerAdapter
import com.abdullaev.smartagro.common.Common
import com.abdullaev.smartagro.common.SharedPreferences
import com.abdullaev.smartagro.databinding.FragmentOnboardingBinding
import com.abdullaev.smartagro.model.BoardingModel
import com.abdullaev.smartagro.model.CurrentQuestion
import com.abdullaev.smartagro.utils.statusBarColor
import vn.beautylife.pagertransformerlibrary.ZoomOutSlideTransformer

class FragmentOnBoarding : Fragment() {
    private lateinit var binding: FragmentOnboardingBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        requireActivity().statusBarColor(
            ResourcesCompat.getColor(resources, R.color.white, requireActivity().theme),
            ResourcesCompat.getColor(resources, R.color.white, requireActivity().theme),
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)


        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            @SuppressLint("SetTextI18n")
            override fun onPageSelected(position: Int) {
                Common.hozirgiSavol = position

                if (position==3){
                    binding.nextDoneTextView.text="Done"
                    binding.skipTextView.visibility=View.GONE
                }else{
                    binding.skipTextView.visibility=View.VISIBLE
                    binding.nextDoneTextView.text="Next"
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

        binding.nextDoneTextView.setOnClickListener {
            if (Common.hozirgiSavol==3){
                SharedPreferences.setLoggedIn(requireContext(), true)
                startActivity(Intent(requireActivity(), MainActivity::class.java))
            }
        }
        binding.skipTextView.setOnClickListener {
            SharedPreferences.setLoggedIn(requireContext(), true)
            startActivity(Intent(requireActivity(), MainActivity::class.java))
        }

        Common.questionNumbers = questionNumbers()


        for (i in 0 until Common.questionNumbers.size) {
            Common.currentQuestions.add(CurrentQuestion(i))
        }

        genFragmentList()

        val questionsFragmentAdapter = FragmentQuestionPagerAdapter(
            childFragmentManager,
            requireContext(), Common.fragmentQuestions
        )
        binding.viewPager.adapter = questionsFragmentAdapter
        binding.dotsIndicator.setViewPager(binding.viewPager)


    }


    private fun genFragmentList() {
        for (i in 0 until Common.questionNumbers.size) {
            val bundle = Bundle()
            bundle.putInt("index", i)
            val fragment = FragmentOnBoardingPages()
            fragment.arguments = bundle
            Common.fragmentQuestions.add(fragment)
        }
    }

    private fun questionNumbers(): ArrayList<BoardingModel> {
        val list = arrayListOf(
            BoardingModel(
                R.drawable.love,
                "Saved Lists",
                "ad;iwdn;awdin a;iwdaw;ioda oa jd;owijda",
            ),
            BoardingModel(
                R.drawable.instagram,
                "Add New Listings",
                "ad;iwdn;awdin a;iwdaw;ioda oa jd;owijda",
            ),
            BoardingModel(
                R.drawable.chat,
                "Cow Farming",
                "produce high quality milk",
            ),
            BoardingModel(
                R.drawable.bell,
                "Cow Farming",
                "produce high quality milk",
            )
        )

        return list
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