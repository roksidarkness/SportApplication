package com.roksidark.foosballmatchesapplication.data.datasource

import com.roksidark.foosballmatchesapplication.data.model.entity.ItemResult
import io.reactivex.rxjava3.core.Observable

interface DataStore {

    fun getItems(): Observable<List<ItemResult>>
}