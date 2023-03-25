package com.roksidark.foosballmatchesapplication.data.repository

import com.roksidark.foosballmatchesapplication.data.datasource.DataStore
import com.roksidark.foosballmatchesapplication.data.model.entity.Game
import com.roksidark.foosballmatchesapplication.domain.repository.GamesRepository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(
    private val dataStore: DataStore
): GamesRepository {

    override fun getGames(): Observable<List<Game>> {
        return dataStore.getItems()
    }

    override fun addGame(game: Game): Single<List<Game>> {
        return dataStore.addItem(game)
    }

    override fun updateGame(game: Game): Single<List<Game>> {
        return dataStore.updateItem(game)
    }
}