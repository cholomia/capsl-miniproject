package com.capsl.miniproject.di

import com.capsl.data.module.ApiModule
import com.capsl.data.module.NetworkModule
import com.capsl.data.module.UseCaseModule
import com.capsl.miniproject.di.module.AndroidComponentModule
import com.capsl.miniproject.di.module.AppModule
import com.capsl.miniproject.di.module.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AndroidComponentModule::class,
        AppModule::class,
        ViewModelModule::class,
        NetworkModule::class,
        ApiModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent : AndroidInjector<DaggerApplication> {

    @Component.Factory
    interface Factory : AndroidInjector.Factory<DaggerApplication>

}