package com.tossdesu.filmography.di

import androidx.fragment.app.FragmentActivity
import dagger.Module
import dagger.Provides

@Module
class PresentationModule {

    @Provides
    fun provideFragmentActivity(): FragmentActivity {
        return FragmentActivity()
    }
}