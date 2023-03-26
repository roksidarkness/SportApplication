package com.roksidark.foosballmatchesapplication.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.roksidark.foosballmatchesapplication.data.model.entity.Game
import com.roksidark.foosballmatchesapplication.data.model.entity.RatingGame
import com.roksidark.foosballmatchesapplication.domain.usecase.GamesUseCases
import com.roksidark.foosballmatchesapplication.util.gamesToRatingGames
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.subjects.PublishSubject
import javax.inject.Inject

class MainViewModel@Inject constructor(
    private val gamesUseCase: GamesUseCases
): ViewModel() {
    private val tag = "MainViewModel"

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val _gamesLiveData = MutableLiveData<List<Game>>()
    val gamesLiveData: LiveData<List<Game>> = _gamesLiveData

    private val ratingPublishSubject = PublishSubject.create<List<Game>>()
    private val ratingPublishSubjectByWon = PublishSubject.create<List<Game>>()

    private val _gamesRatingLiveData = MutableLiveData<List<RatingGame>>()
    val gamesRatingLiveData: LiveData<List<RatingGame>> = _gamesRatingLiveData

    private val _gamesRatingByWonLiveData = MutableLiveData<List<RatingGame>>()
    val gamesRatingByWonLiveData: LiveData<List<RatingGame>> = _gamesRatingByWonLiveData
    
    init{
        compositeDisposable.add(
            ratingPublishSubject
            .map { gamesToRatingGames(it) }
            .map { it.sortedByDescending { it.finishedGames} }
            .subscribe({ ratingGames ->
                _gamesRatingLiveData.postValue(ratingGames)
            }, { error ->
                error.localizedMessage?.let { Log.d(tag, it) }
            })
        )
        compositeDisposable.add(
            ratingPublishSubjectByWon
                .map { gamesToRatingGames(it) }
                .map { it.sortedByDescending { it.wonGames} }
                .subscribe({ ratingGames ->
                    _gamesRatingByWonLiveData.postValue(ratingGames)
                }, { error ->
                    error.localizedMessage?.let { Log.d(tag, it) }
                })
        )
    }

    fun getListGames() {
        compositeDisposable.add(
            gamesUseCase.getGamesUseCase.invoke().subscribe({ games ->
                _gamesLiveData.postValue(games)
                ratingPublishSubject.onNext(games)
                ratingPublishSubjectByWon.onNext(games)
            }, { error ->
                error.localizedMessage?.let { Log.d(tag, it) }
            })
        )
    }

    fun addGame(firstPerson: String, firstPersonScore: String,
                secondPerson: String, secondPersonScore: String) {
        compositeDisposable.add(
            gamesUseCase.addGameUseCase.invoke(
                Game(
                    date = System.currentTimeMillis(),
                    firstPerson = firstPerson,
                    firstPersonScore = firstPersonScore.toInt(),
                    secondPerson = secondPerson,
                    secondPersonScore = secondPersonScore.toInt()
                )
            ).subscribe({ games ->
                _gamesLiveData.postValue(games)
                ratingPublishSubject.onNext(games)
                ratingPublishSubjectByWon.onNext(games)
            }, { error ->
                error.localizedMessage?.let { Log.d(tag, it) }
            })
        )
    }

    fun updateGame(date: Long, firstPerson: String, firstPersonScore: String,
                secondPerson: String, secondPersonScore: String) {
        compositeDisposable.add(
            gamesUseCase.updateGameUseCase.invoke(
                Game(
                    date = date,
                    firstPerson = firstPerson,
                    firstPersonScore = firstPersonScore.toInt(),
                    secondPerson = secondPerson,
                    secondPersonScore = secondPersonScore.toInt()
                )
            ).subscribe({ games ->
                _gamesLiveData.postValue(games)
                ratingPublishSubject.onNext(games)
                ratingPublishSubjectByWon.onNext(games)
            }, { error ->
                error.localizedMessage?.let { Log.d(tag, it) }
            })
        )
    }
}