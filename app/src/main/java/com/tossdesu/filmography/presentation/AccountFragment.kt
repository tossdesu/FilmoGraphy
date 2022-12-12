package com.tossdesu.filmography.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.tossdesu.filmography.R
import com.tossdesu.filmography.databinding.FragmentAccountBinding

class AccountFragment : Fragment() {

    private var _binding: FragmentAccountBinding? = null
    private val binding: FragmentAccountBinding
        get() = _binding ?: throw RuntimeException("FragmentAccountBinding = null")

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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewPagerAdapter()
    }

    private fun initViewPagerAdapter() {
        val vpAdapter = ViewPagerAdapter(requireActivity(), fragmentList)
        binding.vpFragmentsContainer.adapter = vpAdapter
        TabLayoutMediator(binding.tabLayout, binding.vpFragmentsContainer) { tabItem, posItem ->
            tabItem.text = fragTitlesList[posItem]
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}