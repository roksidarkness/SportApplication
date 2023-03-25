package com.roksidark.foosballmatchesapplication.presentation.games.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.roksidark.foosballmatchesapplication.R
import com.roksidark.foosballmatchesapplication.data.model.entity.ItemResultGame

class GameAdapter: RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    private var items: List<ItemResultGame> = mutableListOf()

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

    fun setItems(itemResultGame: List<ItemResultGame>) {
        items = itemResultGame
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: ItemResultGame) = with(itemView) {
            val txtItem = findViewById<TextView>(R.id.textview_item)
            txtItem.text = item.firstPerson + item.firstScore +" - "+item.secondPerson+ item.secondScore
        }
    }
}
