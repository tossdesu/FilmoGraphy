package com.tossdesu.filmography.data.network.entity

data class TopFilmsResponseBody(
    val pagesCount: Int,
    val films: List<TopFilmBriefDataDto>?
)
