package com.tossdesu.filmography.di

import androidx.lifecycle.ViewModel
import com.tossdesu.filmography.presentation.FilmSelectionsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(FilmSelectionsViewModel::class)
    @Binds
    fun bindFilmSelectionsViewModel(viewModel: FilmSelectionsViewModel): ViewModel
}