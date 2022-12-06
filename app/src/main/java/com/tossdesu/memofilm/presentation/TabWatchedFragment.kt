package com.tossdesu.memofilm.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tossdesu.memofilm.R

class TabWatchedFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab_watched, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = TabWatchedFragment()
    }
}