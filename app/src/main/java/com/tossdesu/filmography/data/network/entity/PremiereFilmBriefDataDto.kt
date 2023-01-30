package com.tossdesu.filmography.data.network.entity

import com.tossdesu.filmography.domain.entity.FilmBriefData

data class PremiereFilmBriefDataDto(
    val kinopoiskId: Int,
    val nameRu: String?,
    val posterUrlPreview: String
) {

    fun toFilmBriefData(): FilmBriefData = FilmBriefData(
        kinopoiskId = kinopoiskId,
        nameRu = nameRu ?: "",
        posterUrl = posterUrlPreview
    )
}
