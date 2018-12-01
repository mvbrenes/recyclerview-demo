package com.marcobrenes.recyclerviewdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<RecyclerView>(R.id.recyclerview).apply {
            layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, true)
            adapter = SimpleRVAdapter()
            addItemDecoration(DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL))
        }
    }
}
