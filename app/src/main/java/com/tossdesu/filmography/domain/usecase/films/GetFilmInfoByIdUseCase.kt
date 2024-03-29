package com.tossdesu.filmography.domain.usecase.films

import com.tossdesu.filmography.domain.FilmsRepository

class GetFilmInfoByIdUseCase(
    private val repository: FilmsRepository
) {

    operator fun invoke(filmId: Int) {
        repository.getFilmInfoByIdUseCase(filmId)
    }
}