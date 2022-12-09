package com.tossdesu.filmography.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.tossdesu.filmography.R
import com.tossdesu.filmography.databinding.ActivityAccountBinding

class AccountActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityAccountBinding.inflate(layoutInflater)
    }

    private val fragmentList = listOf(
        TabWillWatchFragment.newInstance(),
        TabWatchedFragment.newInstance(),
        TabFavoriteFragment.newInstance()
    )

    private val fragTitlesList by lazy {
        listOf(
            getString(R.string.title_will_watch),
            getString(R.string.title_watched),
            getString(R.string.title_favorite)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViewPagerAdapter()
    }

    private fun initViewPagerAdapter() {
        val vpAdapter = ViewPagerAdapter(this, fragmentList)
        binding.vpFragmentsContainer.adapter = vpAdapter
        TabLayoutMediator(binding.tabLayout, binding.vpFragmentsContainer) { tabItem, posItem ->
            tabItem.text = fragTitlesList[posItem]
        }.attach()
    }

}