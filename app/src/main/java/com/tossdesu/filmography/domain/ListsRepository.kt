package com.tossdesu.filmography.domain

import com.tossdesu.filmography.domain.entity.FilmBriefData

interface ListsRepository {

    /** WORKING WITH USER LISTS **/
    fun addFilmToWatchedUseCase(film: FilmBriefData)

    fun addFilmToWillWatchUseCase(film: FilmBriefData)

    fun addFilmToFavoriteUseCase(film: FilmBriefData)

    fun moveFilmToWatchedUseCase(filmId: Int)

    fun moveFilmToWillWatchUseCase(filmId: Int)

    fun moveFilmToFavoriteUseCase(filmId: Int)

    fun deleteFilmFromWatchedUseCase(filmId: Int)

    fun deleteFilmFromWillWatchUseCase(filmId: Int)

    fun deleteFilmFromFavoriteUseCase(filmId: Int)
}