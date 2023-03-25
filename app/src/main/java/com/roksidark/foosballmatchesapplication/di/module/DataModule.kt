package com.roksidark.foosballmatchesapplication.di.module

import com.roksidark.foosballmatchesapplication.data.datasource.DataStore
import com.roksidark.foosballmatchesapplication.data.datasource.LocalDataStore
import com.roksidark.foosballmatchesapplication.data.repository.GameRepositoryImpl
import com.roksidark.foosballmatchesapplication.domain.repository.GamesRepository
import com.roksidark.foosballmatchesapplication.domain.usecase.AddGameUseCase
import com.roksidark.foosballmatchesapplication.domain.usecase.GamesUseCases
import com.roksidark.foosballmatchesapplication.domain.usecase.GetGamesUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DataModule {

    @Singleton
    @Provides
    fun providesLocalRepository(): DataStore =
        LocalDataStore()


    @Singleton
    @Provides
    fun providesGamesRepository(localDataStore: LocalDataStore): GamesRepository =
        GameRepositoryImpl(localDataStore)



    @Singleton
    @Provides
    fun provideGamesUseCases(gamesRepository: GamesRepository): GamesUseCases {
        return GamesUseCases(
            getGamesUseCase = GetGamesUseCase(gamesRepository),
            addGameUseCase = AddGameUseCase(gamesRepository)
        )
    }
}