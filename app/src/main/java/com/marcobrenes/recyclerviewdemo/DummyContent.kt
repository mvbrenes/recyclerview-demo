package com.marcobrenes.recyclerviewdemo

import kotlin.random.Random

object DummyContent {

    private const val COUNT = 25
    const val FIXED_MODE = false
    val items = arrayListOf<DummyItem>()
    val itemMap = hashMapOf<String, DummyItem>()

    init {
        (1..COUNT).forEach {
            addItem(createDummyItem(it))
        }
    }

    private fun addItem(item: DummyItem) {
        items.add(item)
        itemMap[item.id] = item
    }

    private fun createDummyItem(position: Int): DummyItem {
        return DummyItem(position.toString(), makeDetails(position), makeDetails(position))
    }

    @Suppress("ConstantConditionIf")
    private fun makeDetails(position: Int): String = with(StringBuffer()) {
        append("Item: $position \n")
        if (FIXED_MODE) {
            append("XXXXXXXX")
        } else {
            (0..Random.nextInt(1, 100)).forEach { append("X") }
        }
        toString()
    }
}

class DummyItem(
    val id: String,
    val content: String,
    val details: String
) {
    override fun toString() = content
}