package com.tossdesu.filmography.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tossdesu.filmography.databinding.FragmentFilmInfoBinding

class FilmInfoFragment : Fragment() {

    private var _binding: FragmentFilmInfoBinding? = null
    private val binding: FragmentFilmInfoBinding
        get() = _binding ?: throw RuntimeException("FragmentFilmInfoBinding = null")

    private var filmId: Int = FILM_ID_EMPTY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parsParams()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFilmInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.filmId.text = filmId.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun parsParams() {
        val args = requireArguments()
        if (!args.containsKey(FILM_ID)) {
            throw RuntimeException("FILM_ID param extra is absent")
        }
        filmId = args.getInt(FILM_ID)
    }

    companion object {
        private const val FILM_ID = "film_id"
        private const val FILM_ID_EMPTY = 0

        fun newInstance(filmId: Int): FilmInfoFragment {
            return FilmInfoFragment().apply {
                arguments = Bundle().apply {
                    putInt(FILM_ID, filmId)
                }
            }
        }
    }
}