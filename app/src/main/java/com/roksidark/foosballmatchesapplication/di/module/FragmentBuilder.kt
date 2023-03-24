package com.roksidark.foosballmatchesapplication.di.module

import com.roksidark.foosballmatchesapplication.presentation.games.GamesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {
    @ContributesAndroidInjector
    abstract fun bindGamesFragment(): GamesFragment


}