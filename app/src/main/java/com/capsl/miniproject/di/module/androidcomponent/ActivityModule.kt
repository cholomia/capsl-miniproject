package com.capsl.miniproject.di.module.androidcomponent

import com.capsl.miniproject.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

}