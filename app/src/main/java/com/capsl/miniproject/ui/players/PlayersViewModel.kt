package com.capsl.miniproject.ui.players

import com.capsl.domain.model.Player
import com.capsl.domain.sealedclass.Resource
import com.capsl.domain.usecase.PlayerUseCase
import com.capsl.miniproject.util.viewmodel.LiveViewModel
import javax.inject.Inject

class PlayersViewModel @Inject constructor(
    private val playerUseCase: PlayerUseCase
) : LiveViewModel<List<Player>>() {

    fun getPlayerList() {
        execute(playerUseCase.getPlayerList())
    }

    fun changePlayerSelectedStatus(player: Player) {
        val playerList = (getResult().value as? Resource.Success)?.data
        val index = playerList?.indexOfFirst { it.id == player.id }
        index?.let {
            val mutablePlayerList = playerList.toMutableList()
            mutablePlayerList[index] = player.copy(isSelected = !player.isSelected)
            result.postValue(Resource.Success(mutablePlayerList))
        }
    }

}