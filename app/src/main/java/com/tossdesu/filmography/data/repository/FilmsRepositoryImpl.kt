package com.tossdesu.filmography.data.repository

import com.tossdesu.filmography.data.network.ApiService
import com.tossdesu.filmography.domain.FilmsRepository
import com.tossdesu.filmography.domain.entity.FilmBriefData
import com.tossdesu.filmography.domain.entity.FilmData
import javax.inject.Inject

class FilmsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : FilmsRepository {

    override fun getFilmInfoByIdUseCase(filmId: Int): FilmData {
        TODO("Not yet implemented")
    }

    override fun searchFilmByTitleUseCase(searchTitle: String): List<FilmBriefData> {
        TODO("Not yet implemented")
    }

    override suspend fun getPopularFilmsUseCase(): List<FilmBriefData>? {
        val responseData = apiService.getTopFilmsSelection("TOP_100_POPULAR_FILMS", 1)
        return responseData.films?.map {
            it.toFilmBriefData()
        }
    }

    override suspend fun getPremiereFilmsUseCase(): List<FilmBriefData>? {
        val responseData = apiService.getPremiereFilms(2023, "FEBRUARY")
        return responseData.items?.map {
            it.toFilmBriefData()
        }
    }

    override suspend fun getTop250FilmsUseCase(): List<FilmBriefData>? {
        val responseData = apiService.getTopFilmsSelection("TOP_250_BEST_FILMS", 1)
        return responseData.films?.map {
            it.toFilmBriefData()
        }
    }
}