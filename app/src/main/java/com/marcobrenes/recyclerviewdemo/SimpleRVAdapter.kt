package com.marcobrenes.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SimpleRVAdapter : RecyclerView.Adapter<SimpleViewHolder>() {

    val data by lazy {
        (1..15).map {
            it.toString()
        }.toTypedArray()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.view_recyclerview_row, parent, false)
            .let { SimpleViewHolder(it) }
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
        holder.bindData(data[position])
    }
}

class SimpleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val textView: TextView = itemView.findViewById(R.id.textview)
    fun bindData(data: String) { textView.text = data }
}
