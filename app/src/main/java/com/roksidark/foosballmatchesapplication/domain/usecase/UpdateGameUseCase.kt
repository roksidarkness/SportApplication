package com.roksidark.foosballmatchesapplication.domain.usecase

import com.roksidark.foosballmatchesapplication.data.model.entity.Game
import com.roksidark.foosballmatchesapplication.domain.repository.GamesRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class UpdateGameUseCase @Inject constructor(private val gamesRepository: GamesRepository) {

    fun invoke(game: Game): Single<List<Game>> {
        return gamesRepository.updateGame(
            Game(
                game.date,
                game.firstPerson,
                game.firstPersonScore,
                game.secondPerson,
                game.secondPersonScore
            )
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}