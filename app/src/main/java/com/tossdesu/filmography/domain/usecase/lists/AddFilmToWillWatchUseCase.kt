package com.tossdesu.filmography.domain.usecase.lists

import com.tossdesu.filmography.domain.FilmsRepository
import com.tossdesu.filmography.domain.entity.FilmBriefData

class AddFilmToWillWatchUseCase(
    private val repository: FilmsRepository
) {

    operator fun invoke(film: FilmBriefData) {
        repository.addFilmToWillWatchUseCase(film)
    }
}