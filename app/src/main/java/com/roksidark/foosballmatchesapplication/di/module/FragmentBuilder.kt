package com.roksidark.foosballmatchesapplication.di.module

import com.roksidark.foosballmatchesapplication.presentation.addgame.AddEditGameFragment
import com.roksidark.foosballmatchesapplication.presentation.games.GamesFragment
import com.roksidark.foosballmatchesapplication.presentation.rating.RatingDialogFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {
    @ContributesAndroidInjector
    abstract fun bindGamesFragment(): GamesFragment

    @ContributesAndroidInjector
    abstract fun bindAddGameFragment(): AddEditGameFragment

    @ContributesAndroidInjector
    abstract fun bindRatingDialogFragment(): RatingDialogFragment
}