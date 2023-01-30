package com.tossdesu.filmography.data.network

import com.squareup.moshi.Moshi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiFactory {

    private const val BASE_URL ="https://kinopoiskapiunofficial.tech/api/v2.2/"
    private const val API_KEY ="61000311-20be-426b-946a-e8067bc1bf0e"

    private val loggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    private val chainInterceptor = Interceptor { chain ->
        val builder = chain.request().newBuilder()
        builder.header("X-API-KEY", API_KEY)
        builder.header("Content-Type", "application/json")
        return@Interceptor chain.proceed(builder.build())
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor(chainInterceptor)
        .build()

    private val moshi = Moshi.Builder().build()
    private val moshiConverterFactory = MoshiConverterFactory.create(moshi)

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(moshiConverterFactory)
        .client(client)
        .baseUrl(BASE_URL)
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}