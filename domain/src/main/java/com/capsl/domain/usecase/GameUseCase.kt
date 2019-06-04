package com.capsl.domain.usecase

import com.capsl.domain.model.Game
import io.reactivex.Single

interface GameUseCase {

    fun getGameList(): Single<List<Game>>

}