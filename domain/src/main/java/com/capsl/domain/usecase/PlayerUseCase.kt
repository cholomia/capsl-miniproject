package com.capsl.domain.usecase

import com.capsl.domain.model.Player
import io.reactivex.Single

interface PlayerUseCase {

    fun getPlayerList(): Single<List<Player>>

}