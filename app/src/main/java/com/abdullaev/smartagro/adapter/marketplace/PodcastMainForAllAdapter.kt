package com.abdullaev.smartagro.adapter.marketplace

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abdullaev.smartagro.databinding.LayoutPodcastMainItemBinding
import com.abdullaev.smartagro.model.TestModel
import com.google.android.material.card.MaterialCardView

class PodcastMainForAllAdapter(private val testModel: List<TestModel>,
                               private val onClickListener: OnClickListener
) : RecyclerView.Adapter<PodcastMainForAllAdapter.AddCardItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddCardItemViewHolder {
        var binding =
            LayoutPodcastMainItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return AddCardItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AddCardItemViewHolder, position: Int) {
        val cardListt: TestModel = testModel[position]
        holder.bind(cardListt, onClickListener)
    }

    override fun getItemCount() = testModel.size

    inner class AddCardItemViewHolder(private val itemBinding: LayoutPodcastMainItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {


        fun bind(card: TestModel, onClickListener: OnClickListener) {
            itemBinding.imageView.setImageResource(card.image)
            itemBinding.imageView.transitionName=card.id
            itemBinding.textView.text=card.title
            itemBinding.textView.transitionName=card.titleId
            itemBinding.materialCardView.transitionName=card.title

            itemView.setOnClickListener {
                onClickListener.onClick(card, itemBinding.materialCardView, itemBinding.imageView, itemBinding.textView)
            }
        }


    }

    class OnClickListener(val clickListener: (TestModel, MaterialCardView, ImageView, TextView) -> Unit) {
        fun onClick(
            testModel: TestModel,
            materialCardView: MaterialCardView,
            iconImageView: ImageView,
            textView: TextView
        ) = clickListener(testModel,materialCardView, iconImageView, textView)
    }


}