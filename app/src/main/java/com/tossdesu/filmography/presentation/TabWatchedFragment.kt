package com.tossdesu.filmography.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tossdesu.filmography.databinding.FragmentTabWatchedBinding

class TabWatchedFragment : Fragment() {

    private var _binding: FragmentTabWatchedBinding? = null
    private val binding: FragmentTabWatchedBinding
        get() = _binding ?: throw RuntimeException("FragmentTabWatchedBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTabWatchedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFilmInfo.setOnClickListener {
            findNavController().navigate(
                AccountFragmentDirections.actionAccountFragmentToFilmInfoFragment(1400)
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = TabWatchedFragment()
    }
}