package com.tossdesu.filmography.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.tossdesu.filmography.R
import com.tossdesu.filmography.databinding.FragmentAccountBinding
import com.tossdesu.filmography.domain.entity.TabItems
import com.tossdesu.filmography.presentation.adapter.ViewPagerAdapter
import javax.inject.Inject

class AccountFragment @Inject constructor() : Fragment() {

    @Inject
    lateinit var viewPagerAdapter: ViewPagerAdapter

    private var _binding: FragmentAccountBinding? = null
    private val binding: FragmentAccountBinding
        get() = _binding ?: throw RuntimeException("FragmentAccountBinding = null")

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
        val vpAdapter = ViewPagerAdapter(requireActivity())
        binding.vpFragmentsContainer.adapter = vpAdapter
        TabLayoutMediator(binding.tabLayout, binding.vpFragmentsContainer) { tabItem, posItem ->
            tabItem.text = when(posItem) {
                TabItems.WILL_WATCH.ordinal -> getString(R.string.title_will_watch)
                TabItems.WATCHED.ordinal -> getString(R.string.title_watched)
                TabItems.FAVORITE.ordinal -> getString(R.string.title_favorite)
                else -> throw RuntimeException("Have no title for posItem = $posItem")
            }
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}