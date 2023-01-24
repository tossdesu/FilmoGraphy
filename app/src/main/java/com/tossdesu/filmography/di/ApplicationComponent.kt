package com.tossdesu.filmography.di

import com.tossdesu.filmography.presentation.MainActivity
import dagger.Component

@Component
interface ApplicationComponent {

    fun inject(activity: MainActivity)

//    @Component.Factory
//    interface Factory {
//
//        fun create(): ApplicationComponent
//    }
}