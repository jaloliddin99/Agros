package com.abdullaev.smartagro.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abdullaev.smartagro.databinding.LayoutSponsorshipItemBinding
import com.abdullaev.smartagro.model.sponsorship.SponsorshipSubItem
import com.google.android.material.card.MaterialCardView

class QuestionPagerAdapter2 (
    private val sponsorItem:ArrayList<SponsorshipSubItem>,
    private val onClickListener:OnClickEvent
) : RecyclerView.Adapter<QuestionPagerAdapter2.AddCardItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddCardItemViewHolder {
        var binding =
            LayoutSponsorshipItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return AddCardItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AddCardItemViewHolder, position: Int) {
        val cardListt: SponsorshipSubItem = sponsorItem[position]
        holder.bind(cardListt)
    }

    override fun getItemCount() = sponsorItem.size

    inner class AddCardItemViewHolder(private val itemBinding: LayoutSponsorshipItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener {


        fun bind(card: SponsorshipSubItem) {
            itemBinding.endDate.text=card.endDate
            itemBinding.startDate.text=card.startDate
            itemBinding.tradeName.text=card.tradeName
            itemBinding.image.setImageResource(card.image)
            itemBinding.materialCardView.transitionName="cardViewTransition$adapterPosition$adapterPosition"


        }
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            onClickListener.clickEventtt(itemBinding.materialCardView, adapterPosition)
        }

    }

    interface OnClickEvent{
        fun clickEventtt(materialCardView: MaterialCardView, tId:Int)
    }

}