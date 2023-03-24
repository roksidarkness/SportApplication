package com.roksidark.foosballmatchesapplication.data.datasource

import com.roksidark.foosballmatchesapplication.data.model.entity.ItemResult
import com.roksidark.foosballmatchesapplication.util.finishedGames
import javax.inject.Inject
import io.reactivex.rxjava3.core.Observable

class LocalDataStore @Inject constructor() : DataStore {

    override fun getItems(): Observable<List<ItemResult>> {
        return Observable.fromArray(finishedGames)
    }
}