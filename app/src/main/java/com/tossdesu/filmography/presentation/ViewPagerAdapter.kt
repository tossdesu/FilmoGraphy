package com.tossdesu.filmography.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.tossdesu.filmography.domain.entity.TabItems

class ViewPagerAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            TabItems.WILL_WATCH.ordinal -> TabWillWatchFragment.newInstance()
            TabItems.WATCHED.ordinal -> TabWatchedFragment.newInstance()
            TabItems.FAVORITE.ordinal -> TabFavoriteFragment.newInstance()
            else -> throw RuntimeException("Have no fragment for tab item position = $position")
        }
    }
}