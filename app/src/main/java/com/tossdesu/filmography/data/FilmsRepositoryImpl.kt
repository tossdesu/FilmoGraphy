package com.tossdesu.filmography.data

import com.tossdesu.filmography.domain.FilmsRepository
import com.tossdesu.filmography.domain.entity.FilmBriefData
import com.tossdesu.filmography.domain.entity.FilmData
import javax.inject.Inject

class FilmsRepositoryImpl @Inject constructor() : FilmsRepository {

    override fun getFilmInfoByIdUseCase(filmId: Int): FilmData {
        TODO("Not yet implemented")
    }

    override fun searchFilmByTitleUseCase(searchTitle: String): List<FilmBriefData> {
        TODO("Not yet implemented")
    }

    override fun getTopRatingFilmsUseCase(): List<FilmBriefData> {
        TODO("Not yet implemented")
    }

    override fun getPremiereFilmsUseCase(): List<FilmBriefData> {
        TODO("Not yet implemented")
    }

    override fun getTopAwaitFilmsUseCase(): List<FilmBriefData> {
        TODO("Not yet implemented")
    }
}