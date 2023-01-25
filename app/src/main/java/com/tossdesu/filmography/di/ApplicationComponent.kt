package com.tossdesu.filmography.di

import com.tossdesu.filmography.presentation.FilmSelectionsFragment
import com.tossdesu.filmography.presentation.MainActivity
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        PresentationModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    fun inject(fragment: FilmSelectionsFragment)

//    @Component.Factory
//    interface Factory {
//
//        fun create(): ApplicationComponent
//    }
}