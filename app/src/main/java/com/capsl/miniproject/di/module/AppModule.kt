package com.capsl.miniproject.di.module

import android.app.Application
import com.capsl.miniproject.di.qualifier.App
import dagger.Module
import dagger.Provides
import dagger.android.support.DaggerApplication

@Module
class AppModule {

    @Provides
    @App
    fun app(daggerApplication: DaggerApplication): Application = daggerApplication

}