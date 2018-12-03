package com.marcobrenes.recyclerviewdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.*
import com.marcobrenes.recyclerviewdemo.drag.OnStartDragListener
import com.marcobrenes.recyclerviewdemo.drag.SimpleItemTouchHelperCallback
import java.lang.IllegalStateException

class ItemFragment : Fragment(), OnStartDragListener {

    companion object {
        const val NUM_COLUMNS = 3
        const val FRAG_LINEAR = 1
        const val FRAG_GRID = 2
        const val FRAG_STAG_GRID = 3
        const val ARG_COLUMN_COUNT = "column_count"

        fun newInstance(columnCount: Int): ItemFragment {
            return ItemFragment().apply {
                arguments = bundleOf(ARG_COLUMN_COUNT to columnCount)
            }
        }
    }

    private var fragType: Int = 1
    private lateinit var itemTouchHelper: ItemTouchHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { fragType = it.getInt(ARG_COLUMN_COUNT) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.recycler_fragment, container, false)
        val adapter = RVAdapter(DummyContent.items)
        itemTouchHelper = ItemTouchHelper(SimpleItemTouchHelperCallback(adapter))

        return (view as? RecyclerView)?.apply {
            this.adapter = adapter
            itemTouchHelper.attachToRecyclerView(this)
            layoutManager = when (fragType) {
                FRAG_LINEAR -> LinearLayoutManager(context)
                FRAG_GRID -> GridLayoutManager(context, NUM_COLUMNS)
                FRAG_STAG_GRID -> StaggeredGridLayoutManager(
                    NUM_COLUMNS,
                    StaggeredGridLayoutManager.VERTICAL
                ).apply {
                    gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
                }
                else -> throw IllegalStateException("Not a valid Frag LayoutManager")
            }
        }
    }

    override fun onStartDrag(viewHolder: RecyclerView.ViewHolder) {
        itemTouchHelper.startDrag(viewHolder)
    }
}