package com.tossdesu.filmography.domain.usecase.films

import com.tossdesu.filmography.domain.FilmsRepository
import javax.inject.Inject

class SearchFilmByTitleUseCase @Inject constructor(
    private val repository: FilmsRepository
) {

    operator fun invoke(searchTitle: String) {
        repository.searchFilmByTitleUseCase(searchTitle)
    }
}