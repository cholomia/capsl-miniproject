package com.capsl.miniproject.di.module

import com.capsl.miniproject.di.module.androidcomponent.ActivityModule
import com.capsl.miniproject.di.module.androidcomponent.FragmentModule
import dagger.Module

@Module(
    includes = [
        ActivityModule::class,
        FragmentModule::class
    ]
)
abstract class AndroidComponentModule