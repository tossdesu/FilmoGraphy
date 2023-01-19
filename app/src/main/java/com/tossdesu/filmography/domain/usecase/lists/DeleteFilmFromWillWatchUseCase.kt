package com.tossdesu.filmography.domain.usecase.lists

import com.tossdesu.filmography.domain.FilmsRepository

class DeleteFilmFromWillWatchUseCase(
    private val repository: FilmsRepository
) {

    operator fun invoke(filmId: Int) {
        repository.deleteFilmFromWillWatchUseCase(filmId)
    }
}