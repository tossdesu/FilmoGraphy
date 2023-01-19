package com.tossdesu.filmography.domain.usecase.films

import com.tossdesu.filmography.domain.FilmsRepository

class GetPremiereFilmsUseCase(
    private val repository: FilmsRepository
) {

    operator fun invoke() {
        repository.getPremiereFilmsUseCase()
    }
}