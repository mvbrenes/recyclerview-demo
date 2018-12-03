package com.marcobrenes.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.marcobrenes.recyclerviewdemo.drag.ItemTouchHelperAdapter
import java.util.*

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val idView: TextView = itemView.findViewById(R.id.id)
    private val contentView: TextView = itemView.findViewById(R.id.content)
    fun bindData(item: DummyItem) {
        idView.text = item.id
        contentView.text = item.content
    }
}

class RVAdapter(private val items: ArrayList<DummyItem>) : RecyclerView.Adapter<ViewHolder>(), ItemTouchHelperAdapter {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.view_recyclerview_row, parent, false)
            .let { ViewHolder(it) }
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(items[position])
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int): Boolean {
        // Use Collections to modify the data
        Collections.swap(items, fromPosition, toPosition)
        notifyItemMoved(fromPosition, toPosition)
        return false
    }

    override fun onItemDismiss(position: Int) {
        // Remove item from data
        items.removeAt(position)
        // Notify that the item was removed
        notifyItemRemoved(position)
    }
}
