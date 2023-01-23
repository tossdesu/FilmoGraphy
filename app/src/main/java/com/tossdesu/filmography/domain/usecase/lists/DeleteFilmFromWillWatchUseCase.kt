package com.tossdesu.filmography.domain.usecase.lists

import com.tossdesu.filmography.domain.ListsRepository

class DeleteFilmFromWillWatchUseCase(
    private val repository: ListsRepository
) {

    operator fun invoke(filmId: Int) {
        repository.deleteFilmFromWillWatchUseCase(filmId)
    }
}