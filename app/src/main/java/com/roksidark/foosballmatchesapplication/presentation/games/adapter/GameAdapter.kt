package com.roksidark.foosballmatchesapplication.presentation.games.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.roksidark.foosballmatchesapplication.R
import com.roksidark.foosballmatchesapplication.data.model.entity.Game

class GameAdapter: RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    private var items: List<Game> = mutableListOf()
    var onItemClick: ((Game) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_game, parent, false
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

    fun setItems(game: List<Game>) {
        items = game
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(items[absoluteAdapterPosition])
            }
        }

        fun bind(item: Game) = with(itemView) {
            val txtItem = findViewById<TextView>(R.id.textview_item)
            txtItem.text = context.getString(R.string.label_games_fragment,
                item.firstPerson, item.firstPersonScore, item.secondPerson, item.secondPersonScore
            )
        }
    }
}
