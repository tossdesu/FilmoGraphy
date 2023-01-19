package com.tossdesu.filmography.domain.usecase.films

import com.tossdesu.filmography.domain.FilmsRepository

class GetTopRatingFilmsUseCase(
    private val repository: FilmsRepository
) {

    operator fun invoke() {
        repository.getTopRatingFilmsUseCase()
    }
}