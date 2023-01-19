package com.tossdesu.filmography.domain.entity

data class FilmData(
    val kinopoiskId: Int,
    val nameRu: String,
    val nameOriginal: String,
    val posterUrl: String,
    val year: String,
    val countries: String,
    val genres: String,
    val filmLength: String,
    val ratingKinopoisk: String,
    val ratingImdb: String,
    val ratingFilmCritics: String,
    val shortDescription: String,
    val description: String
)