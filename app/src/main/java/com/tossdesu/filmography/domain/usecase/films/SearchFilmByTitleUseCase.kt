package com.tossdesu.filmography.domain.usecase.films

import com.tossdesu.filmography.domain.FilmsRepository

class SearchFilmByTitleUseCase(
    private val repository: FilmsRepository
) {

    operator fun invoke(searchTitle: String) {
        repository.searchFilmByTitleUseCase(searchTitle)
    }
}