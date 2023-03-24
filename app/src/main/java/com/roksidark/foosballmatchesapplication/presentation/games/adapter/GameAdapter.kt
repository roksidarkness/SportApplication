package com.roksidark.foosballmatchesapplication.presentation.games.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.roksidark.foosballmatchesapplication.R
import com.roksidark.foosballmatchesapplication.data.model.entity.ItemResult

class GameAdapter: RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    private var items: List<ItemResult> = mutableListOf()

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

    fun setItems(itemResult: List<ItemResult>) {
        items = itemResult
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: ItemResult) = with(itemView) {
            val txtItem = findViewById<TextView>(R.id.textview_item)
            txtItem.text = item.firstPerson + item.firstScore +" - "+item.secondPerson+ item.secondScore
        }
    }
}
