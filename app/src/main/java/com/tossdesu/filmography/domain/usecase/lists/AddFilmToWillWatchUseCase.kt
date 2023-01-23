package com.tossdesu.filmography.domain.usecase.lists

import com.tossdesu.filmography.domain.ListsRepository
import com.tossdesu.filmography.domain.entity.FilmBriefData

class AddFilmToWillWatchUseCase(
    private val repository: ListsRepository
) {

    operator fun invoke(film: FilmBriefData) {
        repository.addFilmToWillWatchUseCase(film)
    }
}