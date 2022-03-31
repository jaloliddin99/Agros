package com.abdullaev.smartagro.fragment.sponsorship

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abdullaev.smartagro.R
import com.abdullaev.smartagro.adapter.NearClinicsAdapter
import com.abdullaev.smartagro.adapter.QuestionPagerAdapter2
import com.abdullaev.smartagro.adapter.SponsorshipAdapter
import com.abdullaev.smartagro.databinding.FragmentRentingBinding
import com.abdullaev.smartagro.databinding.FragmentSponsorshipBinding
import com.abdullaev.smartagro.model.sponsorship.SponsorshipSubItem
import com.abdullaev.smartagro.utils.statusBarColor
import com.google.android.material.card.MaterialCardView
import com.google.android.material.transition.MaterialElevationScale

class FragmentSponsorship: Fragment(), SponsorshipAdapter.OnClickEvent, QuestionPagerAdapter2.OnClickEvent, NearClinicsAdapter.OnChipClickListener{

    private lateinit var binding: FragmentSponsorshipBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentSponsorshipBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }
        exitTransition = null
        reenterTransition = null
        binding.apply {
            recyclerView.apply {
                layoutManager= object : LinearLayoutManager(context, HORIZONTAL, false) {
                    override fun checkLayoutParams(lp: RecyclerView.LayoutParams): Boolean {
                        lp.width = width * 5 / 8
                        return true
                    }
                }

                adapter=SponsorshipAdapter(sponsorshipSubItem(), this@FragmentSponsorship)

            }

            recyclerView2.apply {
                layoutManager= object : LinearLayoutManager(context, HORIZONTAL, false) {
                    override fun checkLayoutParams(lp: RecyclerView.LayoutParams): Boolean {
                        lp.width = width * 5 / 8
                        return true
                    }
                }

                adapter=QuestionPagerAdapter2(sponsorshipSubItem(), this@FragmentSponsorship)
            }

            recyclerViewNear.apply {
                layoutManager=LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter= NearClinicsAdapter(this@FragmentSponsorship)
            }
        }
    }

    private fun sponsorshipSubItem():ArrayList<SponsorshipSubItem>{
        val list= arrayListOf(
            SponsorshipSubItem(R.drawable.cacao, "Coffee Trade", "27th Dec 2021", "27th Dec 2021"),
            SponsorshipSubItem(R.drawable.cacao, "Coffee Trade", "27th Dec 2021", "27th Dec 2021"),
            SponsorshipSubItem(R.drawable.cacao, "Coffee Trade", "27th Dec 2021", "27th Dec 2021"),
            SponsorshipSubItem(R.drawable.cacao, "Coffee Trade", "27th Dec 2021", "27th Dec 2021"),
            SponsorshipSubItem(R.drawable.cacao, "Coffee Trade", "27th Dec 2021", "27th Dec 2021"),
            SponsorshipSubItem(R.drawable.cacao, "Coffee Trade", "27th Dec 2021", "27th Dec 2021"),
        )

        return list
    }

    override fun clickEvent(materialCardView: MaterialCardView, tId: Int) {
        exitTransition = MaterialElevationScale(false).apply {
            duration = 250.toLong()
        }
        reenterTransition = MaterialElevationScale(true).apply {
            duration = 250.toLong()
        }

        val direction: NavDirections =
            FragmentSponsorshipDirections.actionFragmentSponsorshipToFragmentSponsorshipDisplay(
               "$tId",
                true
            )
        val extras = FragmentNavigatorExtras(
            materialCardView to "cardViewTransition${tId}"
        )
        findNavController().navigate(direction, extras)
    }

    override fun clickEventtt(materialCardView: MaterialCardView, tId: Int) {
        exitTransition = MaterialElevationScale(false).apply {
            duration = 250.toLong()
        }
        reenterTransition = MaterialElevationScale(true).apply {
            duration = 250.toLong()
        }

        val direction: NavDirections =
            FragmentSponsorshipDirections.actionFragmentSponsorshipToFragmentSponsorshipDisplay(
                "$tId",
                false
            )
        val extras = FragmentNavigatorExtras(
            materialCardView to "cardViewTransition$tId$tId"
        )
        findNavController().navigate(direction, extras)
    }

    override fun onChipClicked(position: Int) {
    }
}