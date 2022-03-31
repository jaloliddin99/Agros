package com.abdullaev.smartagro.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abdullaev.smartagro.databinding.LayoutMedTurizmNearClinicsBinding

class NearClinicsAdapter (
    private val listener: OnChipClickListener
)
    : RecyclerView.Adapter<NearClinicsAdapter.ClinicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClinicViewHolder {
        val binding=
            LayoutMedTurizmNearClinicsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ClinicViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ClinicViewHolder, position: Int) {
//        val newsItem : MedClinicModel =addBaggageImageList[position]
//        holder.bind(newsItem)
    }

    override fun getItemCount()=4

    inner class ClinicViewHolder(private val itemBinding: LayoutMedTurizmNearClinicsBinding)
        : RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener{


//        fun bind(newsItemBinding: MedClinicModel) {
//            itemBinding.title.text=newsItemBinding.title
//            itemBinding.description.text=newsItemBinding.description
//            itemBinding.image.setImageResource(newsItemBinding.img)
//        }

        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val position:Int=adapterPosition
            if (position!= RecyclerView.NO_POSITION){
                listener.onChipClicked(position)
            }
        }

    }

    interface OnChipClickListener{
        fun onChipClicked(position: Int)
    }
}