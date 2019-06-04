package com.capsl.miniproject.ui.games

import com.capsl.domain.model.Game
import com.capsl.domain.usecase.GameUseCase
import com.capsl.miniproject.util.viewmodel.LiveViewModel
import javax.inject.Inject

class GamesViewModel @Inject constructor(
    private val gameUserCase: GameUseCase
) : LiveViewModel<List<Game>>() {

    fun getGameList() {
        execute(gameUserCase.getGameList())
    }

}