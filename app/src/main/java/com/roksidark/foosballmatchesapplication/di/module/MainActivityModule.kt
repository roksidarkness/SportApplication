package com.roksidark.foosballmatchesapplication.di.module

import com.roksidark.foosballmatchesapplication.presentation.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector()
    abstract fun contributeMainActivity(): MainActivity
}