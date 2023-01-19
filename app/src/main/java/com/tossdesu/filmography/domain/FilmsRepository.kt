package com.tossdesu.filmography.domain

import com.tossdesu.filmography.domain.entity.FilmData
import com.tossdesu.filmography.domain.entity.FilmBriefData

interface FilmsRepository {

    /** GET FILM BY KINOPOISK ID **/
    fun getFilmInfoByIdUseCase(filmId: Int): FilmData

    /** SEARCH FILMS **/
    fun searchFilmByTitleUseCase(searchTitle: String): List<FilmBriefData>

    /** GET FILM COLLECTIONS **/
    fun getTopRatingFilmsUseCase(): List<FilmBriefData>

    fun getPremiereFilmsUseCase(): List<FilmBriefData>

    fun getTopAwaitFilmsUseCase(): List<FilmBriefData>

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