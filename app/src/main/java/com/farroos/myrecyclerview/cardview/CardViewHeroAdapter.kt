package com.farroos.myrecyclerview.cardview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.farroos.myrecyclerview.Hero
import com.farroos.myrecyclerview.databinding.ItemCardviewHeroBinding

class CardViewHeroAdapter(private val lisHero: ArrayList<Hero>): RecyclerView.Adapter<CardViewHeroAdapter.CardViewViewHolder>() {
    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): CardViewViewHolder {
        val binding = ItemCardviewHeroBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return CardViewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        holder.bind(lisHero[position])
    }

    override fun getItemCount(): Int = lisHero.size


    class CardViewViewHolder (private val binding: ItemCardviewHeroBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(hero: Hero) {
            with(binding){
                Glide.with(itemView.context)
                    .load(hero.photo)
                    .apply(RequestOptions().override(350, 550))
                    .into(imgItemPhoto)

                tvItemName.text = hero.name

                tvItemDescription.text = hero.description

                btnSetFavorite.setOnClickListener { Toast.makeText(itemView.context, "Favorite ${hero.name}", Toast.LENGTH_SHORT).show() }
                btnSetShare.setOnClickListener { Toast.makeText(itemView.context, "Share ${hero.name}", Toast.LENGTH_SHORT).show() }
                itemView.setOnClickListener { Toast.makeText(itemView.context, "Kamu memilih ${hero.name}", Toast.LENGTH_SHORT).show() }
            }
        }
    }
}