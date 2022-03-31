package com.abdullaev.smartagro.adapter.renting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abdullaev.smartagro.databinding.LayoutCarRentingBigItemBinding
import com.abdullaev.smartagro.databinding.LayoutRentingItemBinding
import com.abdullaev.smartagro.model.RentModel
import com.abdullaev.smartagro.model.sponsorship.SponsorshipSubItem
import com.google.android.material.card.MaterialCardView

class BottomAdapter(
    private val list: ArrayList<RentModel>
) : RecyclerView.Adapter<BottomAdapter.AddCardItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddCardItemViewHolder {
        var binding =
            LayoutCarRentingBigItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return AddCardItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AddCardItemViewHolder, position: Int) {
        val cardListt: RentModel = list[position]
        holder.bind(cardListt)
    }

    override fun getItemCount() = list.size

    inner class AddCardItemViewHolder(private val itemBinding: LayoutCarRentingBigItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener {


        fun bind(card: RentModel) {
            itemBinding.carImage.setImageResource(card.imege)
            itemBinding.title.text=card.title

        }
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

        }

    }

    interface OnClickEvent{
        fun clickEvent(materialCardView: MaterialCardView, tId:Int)
    }

}