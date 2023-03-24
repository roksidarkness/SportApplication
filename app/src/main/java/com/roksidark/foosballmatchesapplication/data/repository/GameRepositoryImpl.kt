package com.roksidark.foosballmatchesapplication.data.repository

import com.roksidark.foosballmatchesapplication.data.datasource.DataStore
import com.roksidark.foosballmatchesapplication.data.model.entity.ItemResult
import com.roksidark.foosballmatchesapplication.domain.repository.GamesRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(
    private val dataStore: DataStore
): GamesRepository {

    override fun getGames(): Observable<List<ItemResult>> {
        return dataStore.getItems()
    }

}