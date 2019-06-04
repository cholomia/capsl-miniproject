package com.capsl.miniproject

import com.capsl.miniproject.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = DaggerAppComponent.factory()
        .create(this)

    override fun onCreate() {
        super.onCreate()

        setupDebugTools()
    }

    private fun setupDebugTools() {
        Timber.plant(Timber.DebugTree())
    }

}