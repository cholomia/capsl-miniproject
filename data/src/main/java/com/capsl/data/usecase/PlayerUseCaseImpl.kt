package com.capsl.data.usecase

import com.capsl.data.api.PlayersApi
import com.capsl.domain.model.Player
import com.capsl.domain.model.Profile
import com.capsl.domain.usecase.PlayerUseCase
import io.reactivex.Single
import javax.inject.Inject

class PlayerUseCaseImpl @Inject constructor(
    private val playersApi: PlayersApi
) : PlayerUseCase {

    override fun getPlayerList(): Single<List<Player>> = playersApi.getPlayerList()
        .map { response ->
            response.results.map {
                Player(
                    it.id,
                    Profile(
                        it.profile?.userId ?: 0,
                        it.profile?.username,
                        it.profile?.firstName,
                        it.profile?.lastName,
                        it.profile?.clashRoyaleTag,
                        null
                    ),
                    false
                )
            }
        }

}