package com.roksidark.foosballmatchesapplication.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.roksidark.foosballmatchesapplication.data.model.entity.ItemResult
import com.roksidark.foosballmatchesapplication.domain.usecase.GamesUseCases
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.subjects.PublishSubject
import javax.inject.Inject

class MainViewModel@Inject constructor(
    private val gamesUseCase: GamesUseCases
): ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val _gamesLiveData = MutableLiveData<List<ItemResult>>()
    val gamesLiveData: LiveData<List<ItemResult>> = _gamesLiveData

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
}