package com.roksidark.foosballmatchesapplication.data.datasource

import com.roksidark.foosballmatchesapplication.data.model.entity.Game
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface DataStore {
    fun getItems(): Observable<List<Game>>
    fun addItem(game: Game): Single<List<Game>>
    fun updateItem(game: Game): Single<List<Game>>
}