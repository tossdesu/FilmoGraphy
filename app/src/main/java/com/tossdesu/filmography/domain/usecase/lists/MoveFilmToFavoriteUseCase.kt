package com.tossdesu.filmography.domain.usecase.lists

import com.tossdesu.filmography.domain.FilmsRepository

class MoveFilmToFavoriteUseCase(
    private val repository: FilmsRepository
) {

    operator fun invoke(filmId: Int) {
        repository.moveFilmToFavoriteUseCase(filmId)
    }
}