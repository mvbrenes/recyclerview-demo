package com.marcobrenes.recyclerviewdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ViewPager>(R.id.viewpager).apply {
            adapter = RecyclerTabPagerAdapter(supportFragmentManager)
        }
    }
}

class RecyclerTabPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val frag1 by lazy { ItemFragment.newInstance(ItemFragment.FRAG_LINEAR) }
    private val frag2 by lazy { ItemFragment.newInstance(ItemFragment.FRAG_GRID) }
    private val frag3 by lazy { ItemFragment.newInstance(ItemFragment.FRAG_STAG_GRID) }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> frag1
            1 -> frag2
            2 -> frag3
            else -> throw IllegalStateException("Invalid number of tabs")
        }
    }

    override fun getCount(): Int = 3

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "Linear"
            1 -> "Grid"
            2 -> "Staggered"
            else -> null
        }
    }
}