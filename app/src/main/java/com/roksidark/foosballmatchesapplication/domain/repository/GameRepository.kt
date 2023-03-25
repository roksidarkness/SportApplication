package com.roksidark.foosballmatchesapplication.domain.repository

import com.roksidark.foosballmatchesapplication.data.model.entity.ItemResultGame
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface GamesRepository {
    fun getGames(): Observable<List<ItemResultGame>>
    fun addGame(itemResultGame: ItemResultGame): Single<List<ItemResultGame>>
}