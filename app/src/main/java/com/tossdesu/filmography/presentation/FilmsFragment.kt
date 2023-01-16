package com.tossdesu.filmography.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import com.tossdesu.filmography.R
import com.tossdesu.filmography.databinding.FragmentFilmsBinding

class FilmsFragment : Fragment() {

    private var _binding: FragmentFilmsBinding? = null
    private val binding: FragmentFilmsBinding
        get() = _binding ?: throw RuntimeException("FragmentFilmsBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFilmsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ViewCompat.setTransitionName(binding.ivPoster1, binding.ivPoster1.id.toString())
        ViewCompat.setTransitionName(binding.ivPoster2, binding.ivPoster2.id.toString())
        ViewCompat.setTransitionName(binding.ivPoster3, binding.ivPoster3.id.toString())
        ViewCompat.setTransitionName(binding.ivPoster4, binding.ivPoster4.id.toString())
        ViewCompat.setTransitionName(binding.ivPoster5, binding.ivPoster5.id.toString())

        binding.ivPoster1.setOnClickListener { launchFilmInfoFragment(it, R.drawable.poster_1) }
        binding.ivPoster2.setOnClickListener { launchFilmInfoFragment(it, R.drawable.poster_2) }
        binding.ivPoster3.setOnClickListener { launchFilmInfoFragment(it, R.drawable.poster_3) }
        binding.ivPoster4.setOnClickListener { launchFilmInfoFragment(it, R.drawable.poster_4) }
        binding.ivPoster5.setOnClickListener { launchFilmInfoFragment(it, R.drawable.poster_5) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun launchFilmInfoFragment(posterView: View, imageResId: Int) {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .addSharedElement(posterView, imageResId.toString())
            .replace(R.id.bottomNavFragmentContainer, FilmInfoFragment.newInstance(imageResId))
            .addToBackStack(FilmInfoFragment.NAME)
            .commit()
    }

    companion object {

        fun newInstance() = FilmsFragment()
    }
}