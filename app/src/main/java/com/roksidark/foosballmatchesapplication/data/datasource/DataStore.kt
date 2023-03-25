package com.roksidark.foosballmatchesapplication.data.datasource

import com.roksidark.foosballmatchesapplication.data.model.entity.ItemResultGame
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface DataStore {
    fun getItems(): Observable<List<ItemResultGame>>
    fun addItem(game: ItemResultGame): Single<List<ItemResultGame>>
}