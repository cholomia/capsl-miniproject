package com.capsl.miniproject.di.module.androidcomponent

import com.capsl.miniproject.ui.games.GamesFragment
import com.capsl.miniproject.ui.players.PlayersFragment
import com.capsl.miniproject.ui.stages.StagesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun gamesFragment(): GamesFragment

    @ContributesAndroidInjector
    abstract fun stagesFragment(): StagesFragment

    @ContributesAndroidInjector
    abstract fun playersFragment(): PlayersFragment

}