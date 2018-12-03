package com.marcobrenes.recyclerviewdemo.drag

import androidx.recyclerview.widget.ItemTouchHelper

interface ItemTouchHelperViewHolder {

    /**
     * Called when [ItemTouchHelper] registers an item as being moved or swiped
     * Implementations should update the item view to indicate it's active state.
     */
    fun onItemSelected()

    /**
     * Called when [ItemTouchHelper] has completed the move or swipe
     */
    fun onItemClear()
}