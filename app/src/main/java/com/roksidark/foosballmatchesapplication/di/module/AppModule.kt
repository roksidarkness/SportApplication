package com.roksidark.foosballmatchesapplication.di.module

import dagger.Module

@Module(
    includes = [
        ViewModelModule::class,
        DataModule::class
    ]
)
class AppModule {
}