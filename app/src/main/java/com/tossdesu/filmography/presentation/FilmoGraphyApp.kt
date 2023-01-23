package com.tossdesu.filmography.presentation

import android.app.Application
import com.tossdesu.filmography.di.ApplicationComponent
import com.tossdesu.filmography.di.DaggerApplicationComponent

class FilmoGraphyApp : Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.create()
    }
}