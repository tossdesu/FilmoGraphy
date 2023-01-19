package com.tossdesu.filmography.domain.usecase.films

import com.tossdesu.filmography.domain.FilmsRepository

class GetTopAwaitFilmsUseCase(
    private val repository: FilmsRepository
) {

    operator fun invoke() {
        repository.getTopAwaitFilmsUseCase()
    }
}