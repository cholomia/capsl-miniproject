package com.capsl.miniproject.di.module

import androidx.lifecycle.ViewModel
import com.capsl.miniproject.di.mapkey.ViewModelKey
import com.capsl.miniproject.ui.games.GamesViewModel
import com.capsl.miniproject.ui.players.PlayersViewModel
import com.capsl.miniproject.ui.stages.StagesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(GamesViewModel::class)
    abstract fun gamesViewModel(gamesViewModel: GamesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(StagesViewModel::class)
    abstract fun stagesViewModel(stagesViewModel: StagesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PlayersViewModel::class)
    abstract fun playersViewModel(playersViewModel: PlayersViewModel): ViewModel

}