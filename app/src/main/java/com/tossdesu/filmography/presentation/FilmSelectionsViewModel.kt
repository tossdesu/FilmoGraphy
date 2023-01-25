package com.tossdesu.filmography.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tossdesu.filmography.domain.entity.FilmBriefData
import com.tossdesu.filmography.domain.usecase.films.GetTopRatingFilmsUseCase
import javax.inject.Inject

class FilmSelectionsViewModel @Inject constructor(
    private val getTopRatingFilmsUseCase: GetTopRatingFilmsUseCase
): ViewModel() {

    private val _filmsTopRating = MutableLiveData<List<FilmBriefData>>()
    val filmsTopRating: LiveData<List<FilmBriefData>>
        get() = _filmsTopRating

    fun getTopRatingFilms() {
//        _filmsTopRating.value = getTopRatingFilmsUseCase()
        Log.d("TAG", "FilmSelectionsViewModel")
    }
}