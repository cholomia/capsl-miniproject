package com.capsl.data.module

import com.capsl.data.api.GamesApi
import com.capsl.data.api.PlayersApi
import com.capsl.data.api.StagesApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule {

    @Singleton
    @Provides
    fun gamesApi(retrofit: Retrofit): GamesApi = retrofit.create(GamesApi::class.java)

    @Singleton
    @Provides
    fun stagesApi(retrofit: Retrofit): StagesApi = retrofit.create(StagesApi::class.java)

    @Singleton
    @Provides
    fun playersApi(retrofit: Retrofit): PlayersApi = retrofit.create(PlayersApi::class.java)

}