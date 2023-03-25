package com.roksidark.foosballmatchesapplication.data.datasource

import com.roksidark.foosballmatchesapplication.data.model.entity.Game
import com.roksidark.foosballmatchesapplication.util.finishedGames
import javax.inject.Inject
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class LocalDataStore @Inject constructor() : DataStore {

    override fun getItems(): Observable<List<Game>> {
        return Observable.fromArray(finishedGames)
    }

    override fun addItem(game: Game): Single<List<Game>> {
        finishedGames.add(0, game)
        return Single.just(finishedGames)
    }

    override fun updateItem(game: Game): Single<List<Game>> {
        var item: Game? = finishedGames.find { it.date == game.date }
        item?.let {
            it.firstPerson = game.firstPerson
            it.firstPersonScore = game.firstPersonScore
            it.secondPerson = game.secondPerson
            it.secondPersonScore = game.secondPersonScore
            it.date = System.currentTimeMillis()
        }
        return Single.just(finishedGames)
    }
}