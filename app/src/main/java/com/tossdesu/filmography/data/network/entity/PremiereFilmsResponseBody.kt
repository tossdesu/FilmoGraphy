package com.tossdesu.filmography.data.network.entity

data class PremiereFilmsResponseBody(
    val total: Int,
    val items: List<PremiereFilmBriefDataDto>?
)
