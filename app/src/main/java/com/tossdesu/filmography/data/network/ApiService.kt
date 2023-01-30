package com.tossdesu.filmography.data.network

import com.tossdesu.filmography.data.network.entity.TopFilmsResponseBody
import com.tossdesu.filmography.data.network.entity.PremiereFilmsResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("films/top")
    suspend fun getTopFilmsSelection(
        @Query("type") selectionType: String,
        @Query("page") page: Int
    ): TopFilmsResponseBody

    @GET("films/premieres")
    suspend fun getPremiereFilms(
        @Query("year") year: Int,
        @Query("month") month: String
    ): PremiereFilmsResponseBody
}