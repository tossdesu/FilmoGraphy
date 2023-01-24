package com.tossdesu.filmography.domain.usecase.lists

import com.tossdesu.filmography.domain.ListsRepository
import com.tossdesu.filmography.domain.entity.FilmBriefData

class AddFilmToFavoriteUseCase(
    private val repository: ListsRepository
) {

    operator fun invoke(film: FilmBriefData) {
        repository.addFilmToFavoriteUseCase(film)
    }
}