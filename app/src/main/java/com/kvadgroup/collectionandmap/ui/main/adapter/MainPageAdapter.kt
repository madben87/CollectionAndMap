package com.kvadgroup.collectionandmap.ui.main.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class MainPageAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    private var titles: ArrayList<String> = ArrayList()
    private var fragments: ArrayList<Fragment> = ArrayList()

    override fun getItem(p0: Int): Fragment {
        return fragments[p0];
    }

    override fun getCount(): Int {
        return fragments.size
    }

    fun addFragment(fragment: Fragment, title: String) {
        fragments.add(fragment)
        titles.add(title)
    }

    fun getTitle(index: Int): CharSequence {
        return titles[index]
    }
}