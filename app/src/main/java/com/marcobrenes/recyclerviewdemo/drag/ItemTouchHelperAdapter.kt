package com.marcobrenes.recyclerviewdemo.drag

interface ItemTouchHelperAdapter {
    /**
     * Called when an item has been dragged far enough to trigger a move
     */
    fun onItemMove(fromPosition: Int, toPosition: Int): Boolean

    /**
     * Called when an item has been dismissed by a swipe
     */
    fun onItemDismiss(position: Int)
}