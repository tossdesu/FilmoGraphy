package com.tossdesu.filmography.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tossdesu.filmography.domain.entity.FilmBriefData
import com.tossdesu.filmography.domain.usecase.films.GetPopularFilmsUseCase
import com.tossdesu.filmography.domain.usecase.films.GetPremiereFilmsUseCase
import com.tossdesu.filmography.domain.usecase.films.GetTop250FilmsUseCase
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class FilmSelectionsViewModel @Inject constructor(
    private val getPopularFilmsUseCase: GetPopularFilmsUseCase,
    private val getTop250FilmsUseCase: GetTop250FilmsUseCase,
    private val getPremiereFilmsUseCase: GetPremiereFilmsUseCase
): ViewModel() {

    private val _state = MutableLiveData<FilmSelectionsState>()
    val state: LiveData<FilmSelectionsState>
        get() = _state

    fun getFilmSelections() {

        _state.value = Progress

        val deferredPopularFilms: Deferred<List<FilmBriefData>> = viewModelScope.async {
            val popularFilms = getPopularFilmsUseCase()
            popularFilms ?: listOf<FilmBriefData>()
        }
        val deferredPremiereFilms: Deferred<List<FilmBriefData>> = viewModelScope.async {
            val premiereFilms = getPremiereFilmsUseCase()
            premiereFilms ?: listOf<FilmBriefData>()
        }
        val deferredTop250Films: Deferred<List<FilmBriefData>> = viewModelScope.async {
            val top250Films = getTop250FilmsUseCase()
            top250Films ?: listOf<FilmBriefData>()
        }

        viewModelScope.launch {
            val popularFilms = deferredPopularFilms.await()
            val premiereFilms = deferredPremiereFilms.await()
            val top250Films = deferredTop250Films.await()
            _state.value = ResponseFilmsData(
                popularFilms,
                top250Films,
                premiereFilms
            )
        }
    }
}