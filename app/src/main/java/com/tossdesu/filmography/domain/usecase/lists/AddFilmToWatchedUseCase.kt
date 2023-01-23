package com.tossdesu.filmography.domain.usecase.lists

import com.tossdesu.filmography.domain.ListsRepository
import com.tossdesu.filmography.domain.entity.FilmBriefData

class AddFilmToWatchedUseCase(
    private val repository: ListsRepository
) {

    operator fun invoke(film: FilmBriefData) {
        repository.addFilmToWatchedUseCase(film)
    }
}