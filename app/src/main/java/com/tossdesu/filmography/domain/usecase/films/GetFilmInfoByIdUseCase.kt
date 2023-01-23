package com.tossdesu.filmography.domain.usecase.films

import com.tossdesu.filmography.domain.FilmsRepository
import javax.inject.Inject

class GetFilmInfoByIdUseCase @Inject constructor(
    private val repository: FilmsRepository
) {

    operator fun invoke(filmId: Int) {
        repository.getFilmInfoByIdUseCase(filmId)
    }
}