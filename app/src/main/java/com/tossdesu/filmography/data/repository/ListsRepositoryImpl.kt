package com.tossdesu.filmography.data.repository

import com.tossdesu.filmography.domain.ListsRepository
import com.tossdesu.filmography.domain.entity.FilmBriefData
import javax.inject.Inject

class ListsRepositoryImpl @Inject constructor() : ListsRepository {

    override fun addFilmToWatchedUseCase(film: FilmBriefData) {
        TODO("Not yet implemented")
    }

    override fun addFilmToWillWatchUseCase(film: FilmBriefData) {
        TODO("Not yet implemented")
    }

    override fun addFilmToFavoriteUseCase(film: FilmBriefData) {
        TODO("Not yet implemented")
    }

    override fun moveFilmToWatchedUseCase(filmId: Int) {
        TODO("Not yet implemented")
    }

    override fun moveFilmToWillWatchUseCase(filmId: Int) {
        TODO("Not yet implemented")
    }

    override fun moveFilmToFavoriteUseCase(filmId: Int) {
        TODO("Not yet implemented")
    }

    override fun deleteFilmFromWatchedUseCase(filmId: Int) {
        TODO("Not yet implemented")
    }

    override fun deleteFilmFromWillWatchUseCase(filmId: Int) {
        TODO("Not yet implemented")
    }

    override fun deleteFilmFromFavoriteUseCase(filmId: Int) {
        TODO("Not yet implemented")
    }
}