package com.tossdesu.filmography.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tossdesu.filmography.R
import com.tossdesu.filmography.databinding.FragmentTabFavoriteBinding

class TabFavoriteFragment : Fragment() {

    private var _binding: FragmentTabFavoriteBinding? = null
    private val binding: FragmentTabFavoriteBinding
        get() = _binding ?: throw RuntimeException("FragmentTabFavoriteBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTabFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFilmInfo.setOnClickListener {
            launchFilmInfoFragment(100)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun launchFilmInfoFragment(filmId: Int) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.bottomNavFragmentContainer, FilmInfoFragment.newInstance(filmId))
            .addToBackStack(null)
            .commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() = TabFavoriteFragment()
    }
}