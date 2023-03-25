package com.roksidark.foosballmatchesapplication.data.repository

import com.roksidark.foosballmatchesapplication.data.datasource.DataStore
import com.roksidark.foosballmatchesapplication.data.model.entity.ItemResultGame
import com.roksidark.foosballmatchesapplication.domain.repository.GamesRepository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(
    private val dataStore: DataStore
): GamesRepository {

    override fun getGames(): Observable<List<ItemResultGame>> {
        return dataStore.getItems()
    }

    override fun addGame(itemResultGame: ItemResultGame): Single<List<ItemResultGame>> {
        return dataStore.addItem(itemResultGame)
    }

}