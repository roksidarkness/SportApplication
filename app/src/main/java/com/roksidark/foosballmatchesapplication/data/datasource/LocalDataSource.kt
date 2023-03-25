package com.roksidark.foosballmatchesapplication.data.datasource

import com.roksidark.foosballmatchesapplication.data.model.entity.ItemResultGame
import com.roksidark.foosballmatchesapplication.util.finishedGames
import javax.inject.Inject
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class LocalDataStore @Inject constructor() : DataStore {

    override fun getItems(): Observable<List<ItemResultGame>> {
        return Observable.fromArray(finishedGames)
    }

    override fun addItem(game: ItemResultGame): Single<List<ItemResultGame>> {
        finishedGames.add(0, game)
        return Single.just(finishedGames)
    }
}