package com.roksidark.foosballmatchesapplication.domain.usecase

import com.roksidark.foosballmatchesapplication.data.model.entity.ItemResultGame
import com.roksidark.foosballmatchesapplication.domain.repository.GamesRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class AddGameUseCase @Inject constructor(private val gamesRepository: GamesRepository) {

    fun invoke(itemResultGame: ItemResultGame): Single<List<ItemResultGame>> {
        return gamesRepository.addGame(
            ItemResultGame(
                System.currentTimeMillis(),
                itemResultGame.firstPerson,
                itemResultGame.firstScore,
                itemResultGame.secondPerson,
                itemResultGame.secondScore
            )
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}