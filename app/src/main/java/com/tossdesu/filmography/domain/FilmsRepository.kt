package com.tossdesu.filmography.domain

import com.tossdesu.filmography.domain.entity.FilmBriefData
import com.tossdesu.filmography.domain.entity.FilmData

interface FilmsRepository {

    /** GET FILM BY KINOPOISK ID **/
    fun getFilmInfoByIdUseCase(filmId: Int): FilmData

    /** SEARCH FILMS **/
    fun searchFilmByTitleUseCase(searchTitle: String): List<FilmBriefData>

    /** GET FILM COLLECTIONS **/
    suspend fun getPopularFilmsUseCase(): List<FilmBriefData>?

    suspend fun getPremiereFilmsUseCase(): List<FilmBriefData>?

    suspend fun getTop250FilmsUseCase(): List<FilmBriefData>?
}