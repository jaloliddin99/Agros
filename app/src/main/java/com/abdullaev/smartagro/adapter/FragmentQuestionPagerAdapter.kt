package com.abdullaev.smartagro.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.abdullaev.smartagro.common.Common
import com.abdullaev.smartagro.fragment.boarding.FragmentOnBoardingPages


class FragmentQuestionPagerAdapter(
    fm: FragmentManager,
    var context: Context,
    var fragments: List<FragmentOnBoardingPages>
) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }


    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        Common.engOxirgiList = position
        return StringBuilder("Savol ").append(position + 1).toString()
    }
}