package com.marcobrenes.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val idView: TextView = itemView.findViewById(R.id.id)
    private val contentView: TextView = itemView.findViewById(R.id.content)
    fun bindData(item: DummyItem) {
        idView.text = item.id
        contentView.text = item.content
    }
}

class RVAdapter(val items: List<DummyItem>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.view_recyclerview_row, parent, false)
            .let { ViewHolder(it) }
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(items[position])
    }
}
