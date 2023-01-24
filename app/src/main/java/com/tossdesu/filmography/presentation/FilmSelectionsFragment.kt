package com.tossdesu.filmography.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tossdesu.filmography.R
import com.tossdesu.filmography.databinding.FragmentFilmSelectionsBinding
import javax.inject.Inject

class FilmSelectionsFragment @Inject constructor() : Fragment() {

    private var _binding: FragmentFilmSelectionsBinding? = null
    private val binding: FragmentFilmSelectionsBinding
        get() = _binding ?: throw RuntimeException("FragmentFilmSelectionsBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFilmSelectionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        ViewCompat.setTransitionName(binding.ivPoster1, binding.ivPoster1.id.toString())
//        binding.ivPoster1.setOnClickListener { launchFilmInfoFragment(it, R.drawable.poster_1) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun launchFilmPosterFragment(posterView: View, imageResId: Int) {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .addSharedElement(posterView, imageResId.toString())
            .replace(R.id.bottomNavFragmentContainer, FilmPosterFragment.newInstance(imageResId))
            .addToBackStack(FilmPosterFragment.NAME)
            .commit()
    }

    companion object {

        fun newInstance() = FilmSelectionsFragment()
    }
}