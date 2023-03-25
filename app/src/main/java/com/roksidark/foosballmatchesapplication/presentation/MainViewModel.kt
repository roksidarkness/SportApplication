package com.roksidark.foosballmatchesapplication.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.roksidark.foosballmatchesapplication.data.model.entity.ItemResultGame
import com.roksidark.foosballmatchesapplication.domain.usecase.GamesUseCases
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class MainViewModel@Inject constructor(
    private val gamesUseCase: GamesUseCases
): ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val _gamesLiveData = MutableLiveData<List<ItemResultGame>>()
    val gamesLiveData: LiveData<List<ItemResultGame>> = _gamesLiveData

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
                ItemResultGame(
                    date = System.currentTimeMillis(),
                    firstPerson = firstPerson,
                    firstScore = firstPersonScore.toInt(),
                    secondPerson = secondPerson,
                    secondScore = secondPersonScore.toInt()
                )
            ).subscribe({ games ->
                _gamesLiveData.postValue(games)
            }, { error ->
                error.localizedMessage?.let { Log.d("MainViewModel", it) }
            })
        )
    }
}