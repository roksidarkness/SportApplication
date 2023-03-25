package com.roksidark.foosballmatchesapplication.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.roksidark.foosballmatchesapplication.data.model.entity.Game
import com.roksidark.foosballmatchesapplication.domain.usecase.GamesUseCases
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class MainViewModel@Inject constructor(
    private val gamesUseCase: GamesUseCases
): ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val _gamesLiveData = MutableLiveData<List<Game>>()
    val gamesLiveData: LiveData<List<Game>> = _gamesLiveData

    fun getListGames() {
        compositeDisposable.add(
            gamesUseCase.getGamesUseCase.invoke().subscribe({ games ->
                _gamesLiveData.postValue(games)
                Log.d("MainViewModel", "it")
            }, { error ->
                error.localizedMessage?.let { Log.d("MainViewModel", it) }
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
            }, { error ->
                error.localizedMessage?.let { Log.d("MainViewModel", it) }
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
            }, { error ->
                error.localizedMessage?.let { Log.d("MainViewModel", it) }
            })
        )
    }
}