package com.tossdesu.filmography.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import com.tossdesu.filmography.databinding.FragmentSearchBinding
import javax.inject.Inject

class SearchFragment @Inject constructor() : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding: FragmentSearchBinding
        get() = _binding ?: throw RuntimeException("FragmentSearchBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchView.isIconified = false
        setSearchViewListeners()
    }

    override fun onStop() {
        super.onStop()
        clearSearchView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setSearchViewListeners() {
        binding.searchView.setOnQueryTextFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                view.postDelayed({
                    val manager = requireActivity()
                        .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    manager.showSoftInput(view.findFocus(), 0)
                }, 200)
            }
        }
        binding.searchView.setOnCloseListener {
            clearSearchView()
            true
        }
    }

    private fun clearSearchView() {
        binding.searchView.setQuery("", false)
    }
}