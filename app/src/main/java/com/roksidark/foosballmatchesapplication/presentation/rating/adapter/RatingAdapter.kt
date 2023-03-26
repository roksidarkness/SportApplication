package com.roksidark.foosballmatchesapplication.presentation.rating.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.roksidark.foosballmatchesapplication.R
import com.roksidark.foosballmatchesapplication.data.model.entity.RatingGame

class RatingAdapter: RecyclerView.Adapter<RatingAdapter.ViewHolder>() {

    private var items: List<RatingGame> = mutableListOf()
    var onItemClick: ((RatingGame) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_rating, parent, false
        )
    )

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    fun setItems(game: List<RatingGame>) {
        items = game
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(items[absoluteAdapterPosition])
            }
        }

        fun bind(item: RatingGame) = with(itemView) {
            val txtItem = findViewById<TextView>(R.id.textview_person)
            val txtItemWon = findViewById<TextView>(R.id.textview_games_won)
            val txtItemFinished = findViewById<TextView>(R.id.textview_games_finished)
            txtItem.text = item.person
            txtItemWon.text = item.wonGames.toString()
            txtItemFinished.text= item.finishedGames.toString()
        }
    }
}