package com.tossdesu.filmography.presentation

import androidx.lifecycle.ViewModel
import com.tossdesu.filmography.domain.usecase.films.GetTopRatingFilmsUseCase
import javax.inject.Inject

class FilmSelectionsViewModel @Inject constructor(
    private val getTopRatingFilmsUseCase: GetTopRatingFilmsUseCase
): ViewModel() {

    fun getTopRatingFilms() {
        getTopRatingFilmsUseCase()
    }
}