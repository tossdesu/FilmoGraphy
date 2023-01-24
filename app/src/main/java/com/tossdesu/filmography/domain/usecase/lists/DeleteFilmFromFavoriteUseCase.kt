package com.tossdesu.filmography.domain.usecase.lists

import com.tossdesu.filmography.domain.ListsRepository

class DeleteFilmFromFavoriteUseCase(
    private val repository: ListsRepository
) {

    operator fun invoke(filmId: Int) {
        repository.deleteFilmFromFavoriteUseCase(filmId)
    }
}