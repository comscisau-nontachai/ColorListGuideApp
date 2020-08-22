package com.dev.colorlistguideapp.adapter

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dev.colorlistguideapp.R
import com.dev.colorlistguideapp.ui.ListColorFavFragment
import com.dev.colorlistguideapp.ui.ListColorFragment

class ViewPagerAdapter(val context: Context,fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment = when(position){
        0 -> ListColorFragment()
        else -> ListColorFavFragment()
    }

    override fun getCount(): Int = 2

    override fun getItemPosition(`object`: Any): Int {
        return super.getItemPosition(`object`)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 ->  context.resources.getString(R.string.title_list)
            else -> context.resources.getString(R.string.title_favorite)
        }
    }
}