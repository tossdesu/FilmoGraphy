package com.tossdesu.filmography.domain.usecase.lists

import com.tossdesu.filmography.domain.FilmsRepository

class MoveFilmToWatchedUseCase(
    private val repository: FilmsRepository
) {

    operator fun invoke(filmId: Int) {
        repository.moveFilmToWatchedUseCase(filmId)
    }
}