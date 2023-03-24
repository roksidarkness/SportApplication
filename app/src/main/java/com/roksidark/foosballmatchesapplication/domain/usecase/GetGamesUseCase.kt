package com.roksidark.foosballmatchesapplication.domain.usecase

import com.roksidark.foosballmatchesapplication.data.model.entity.ItemResult
import com.roksidark.foosballmatchesapplication.domain.repository.GamesRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class GetGamesUseCase @Inject constructor(private val gamesRepository: GamesRepository) {

    fun invoke(): Observable<List<ItemResult>> {
        return gamesRepository.getGames()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}