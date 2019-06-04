package com.capsl.data.usecase

import com.capsl.data.api.GamesApi
import com.capsl.domain.model.Game
import com.capsl.domain.usecase.GameUseCase
import io.reactivex.Single
import javax.inject.Inject

class GameUseCaseImpl @Inject constructor(
    private val gamesApi: GamesApi
) : GameUseCase {

    override fun getGameList(): Single<List<Game>> = gamesApi.getGameList()
        .map { response -> response.results.map { Game(it.id, it.name, it.image, it.packageId) } }

}