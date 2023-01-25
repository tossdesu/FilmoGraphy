package com.tossdesu.filmography.di

import com.tossdesu.filmography.data.FilmsRepositoryImpl
import com.tossdesu.filmography.data.ListsRepositoryImpl
import com.tossdesu.filmography.domain.FilmsRepository
import com.tossdesu.filmography.domain.ListsRepository
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindFilmsRepositoryImpl(impl: FilmsRepositoryImpl): FilmsRepository

    @Binds
    @ApplicationScope
    fun bindListsRepositoryImpl(impl: ListsRepositoryImpl): ListsRepository
}