package com.roksidark.foosballmatchesapplication.domain.repository

import com.roksidark.foosballmatchesapplication.data.model.entity.ItemResult
import io.reactivex.rxjava3.core.Observable

interface GamesRepository {

    fun getGames(): Observable<List<ItemResult>>
}