package com.abdullaev.smartagro.adapter.marketplace

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abdullaev.smartagro.databinding.LayoutPodcastMainViewpagerItemBinding
import com.abdullaev.smartagro.model.RentModel

class PodcastMainViewpager(
    private val list:ArrayList<RentModel>,
    private val listener:OnItemClick
) : RecyclerView.Adapter<PodcastMainViewpager.AddCardItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddCardItemViewHolder {
        val binding =
            LayoutPodcastMainViewpagerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return AddCardItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AddCardItemViewHolder, position: Int) {
        val cardListt: RentModel = list[position]
        holder.bind(cardListt)
    }

    override fun getItemCount() = list.size

    inner class AddCardItemViewHolder(private val itemBinding: LayoutPodcastMainViewpagerItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener {

        fun bind(model: RentModel){
            itemBinding.imageView.setImageResource(model.imege)
            itemBinding.text.text=model.title
        }

        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            listener.viewPagerClicked()
        }

    }

    interface OnItemClick{
        fun viewPagerClicked()
    }

}