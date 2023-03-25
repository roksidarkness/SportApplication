package com.roksidark.foosballmatchesapplication.domain.repository

import com.roksidark.foosballmatchesapplication.data.model.entity.Game
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface GamesRepository {
    fun getGames(): Observable<List<Game>>
    fun addGame(game: Game): Single<List<Game>>
    fun updateGame(game: Game): Single<List<Game>>
}