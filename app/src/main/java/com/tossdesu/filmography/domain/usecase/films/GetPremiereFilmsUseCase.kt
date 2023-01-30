package com.tossdesu.filmography.domain.usecase.films

import com.tossdesu.filmography.domain.FilmsRepository
import com.tossdesu.filmography.domain.entity.FilmBriefData
import javax.inject.Inject

class GetPremiereFilmsUseCase @Inject constructor(
    private val repository: FilmsRepository
) {

    suspend operator fun invoke(): List<FilmBriefData>? {
        return repository.getPremiereFilmsUseCase()
    }
}