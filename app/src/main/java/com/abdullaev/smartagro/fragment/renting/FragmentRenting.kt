package com.abdullaev.smartagro.fragment.renting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.abdullaev.smartagro.R
import com.abdullaev.smartagro.adapter.NearClinicsAdapter
import com.abdullaev.smartagro.adapter.renting.BottomAdapter
import com.abdullaev.smartagro.adapter.renting.TopAdapter
import com.abdullaev.smartagro.databinding.FragmentMarketplaceBinding
import com.abdullaev.smartagro.databinding.FragmentRentingBinding
import com.abdullaev.smartagro.model.RentModel

class FragmentRenting : Fragment(), NearClinicsAdapter.OnChipClickListener{

    private lateinit var binding: FragmentRentingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentRentingBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            topRecyclerView.apply {
                layoutManager=LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter= TopAdapter(combineList())
            }

            recyclerViewBottom.apply {
                layoutManager=LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter= BottomAdapter(combineList())
            }


            recyclerViewNear.apply {
                layoutManager=LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter= NearClinicsAdapter(this@FragmentRenting)
            }

        }
    }

    private fun combineList():ArrayList<RentModel>{
        val list= arrayListOf(
            RentModel(R.drawable.tractor,"Tractor"),
            RentModel(R.drawable.com,"Combine"),
            RentModel(R.drawable.com,"Combine"),
            RentModel(R.drawable.tractor,"Tractor")
        )

        return list
    }

    override fun onChipClicked(position: Int) {
        findNavController().navigate(FragmentRentingDirections.actionFragmentRentingToMapsFragment())
    }

}