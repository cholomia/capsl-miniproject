package com.capsl.data.module

import com.capsl.data.usecase.GameUseCaseImpl
import com.capsl.data.usecase.PlayerUseCaseImpl
import com.capsl.data.usecase.StageUseCaseImpl
import com.capsl.domain.usecase.GameUseCase
import com.capsl.domain.usecase.PlayerUseCase
import com.capsl.domain.usecase.StageUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun gameUseCase(gamesUseCaseImpl: GameUseCaseImpl): GameUseCase = gamesUseCaseImpl

    @Provides
    fun stageUseCase(stageUseCaseImpl: StageUseCaseImpl): StageUseCase = stageUseCaseImpl

    @Provides
    fun playerUseCase(playerUseCaseImpl: PlayerUseCaseImpl): PlayerUseCase = playerUseCaseImpl

}