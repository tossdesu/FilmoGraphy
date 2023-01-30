package com.tossdesu.filmography.domain.usecase.films

import com.tossdesu.filmography.domain.FilmsRepository
import com.tossdesu.filmography.domain.entity.FilmBriefData
import javax.inject.Inject

class GetTop250FilmsUseCase @Inject constructor(
    private val repository: FilmsRepository
) {

    suspend operator fun invoke(): List<FilmBriefData>? {
        return repository.getTop250FilmsUseCase()
    }
}