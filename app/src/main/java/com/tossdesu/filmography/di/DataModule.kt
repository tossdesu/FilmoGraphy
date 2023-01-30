package com.tossdesu.filmography.di

import com.tossdesu.filmography.data.network.ApiFactory
import com.tossdesu.filmography.data.network.ApiService
import com.tossdesu.filmography.data.repository.FilmsRepositoryImpl
import com.tossdesu.filmography.data.repository.ListsRepositoryImpl
import com.tossdesu.filmography.domain.FilmsRepository
import com.tossdesu.filmography.domain.ListsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindFilmsRepositoryImpl(impl: FilmsRepositoryImpl): FilmsRepository

    @Binds
    @ApplicationScope
    fun bindListsRepositoryImpl(impl: ListsRepositoryImpl): ListsRepository

    companion object {

        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}