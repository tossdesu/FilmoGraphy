package com.tossdesu.filmography.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tossdesu.filmography.R
import com.tossdesu.filmography.databinding.FragmentFilmSelectionsBinding
import com.tossdesu.filmography.presentation.adapter.FilmsAdapter
import javax.inject.Inject

class FilmSelectionsFragment @Inject constructor() : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    @Inject
    lateinit var filmsAdapter: FilmsAdapter

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[FilmSelectionsViewModel::class.java]
    }

    private val component by lazy {
        (requireActivity().application as FilmoGraphyApp).component
    }

    private var _binding: FragmentFilmSelectionsBinding? = null
    private val binding: FragmentFilmSelectionsBinding
        get() = _binding ?: throw RuntimeException("FragmentFilmSelectionsBinding = null")

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFilmSelectionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getTopRatingFilms()
        viewModel.filmsTopRating.observe(viewLifecycleOwner) {
            filmsAdapter.submitList(it)
        }

        binding.rvTopRatingFilms.adapter = filmsAdapter
        filmsAdapter.setOnClickListener = {
            // TODO: Launch FilmPosterFragment with Transition for image
        }
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
}