package com.tossdesu.filmography.data.network.entity

import com.tossdesu.filmography.domain.entity.FilmBriefData

data class TopFilmBriefDataDto(
    val filmId: Int,
    val nameRu: String?,
    val posterUrlPreview: String
) {

    fun toFilmBriefData(): FilmBriefData = FilmBriefData(
        kinopoiskId = filmId,
        nameRu = nameRu ?: "",
        posterUrl = posterUrlPreview
    )
}
