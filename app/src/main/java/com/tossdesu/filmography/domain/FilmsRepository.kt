package com.tossdesu.filmography.domain

import com.tossdesu.filmography.domain.entity.FilmBriefData
import com.tossdesu.filmography.domain.entity.FilmData

interface FilmsRepository {

    /** GET FILM BY KINOPOISK ID **/
    fun getFilmInfoByIdUseCase(filmId: Int): FilmData

    /** SEARCH FILMS **/
    fun searchFilmByTitleUseCase(searchTitle: String): List<FilmBriefData>

    /** GET FILM COLLECTIONS **/
    fun getTopRatingFilmsUseCase(): List<FilmBriefData>

    fun getPremiereFilmsUseCase(): List<FilmBriefData>

    fun getTopAwaitFilmsUseCase(): List<FilmBriefData>
}