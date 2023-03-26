package com.roksidark.foosballmatchesapplication.presentation

import com.nhaarman.mockitokotlin2.mock
import com.roksidark.foosballmatchesapplication.data.model.entity.Game
import com.roksidark.foosballmatchesapplication.domain.repository.GamesRepository
import com.roksidark.foosballmatchesapplication.domain.usecase.AddGameUseCase
import com.roksidark.foosballmatchesapplication.domain.usecase.GamesUseCases
import com.roksidark.foosballmatchesapplication.domain.usecase.GetGamesUseCase
import com.roksidark.foosballmatchesapplication.domain.usecase.UpdateGameUseCase
import com.roksidark.foosballmatchesapplication.util.getValueForTest
import io.reactivex.rxjava3.core.Observable
import junit.framework.TestCase.assertEquals
import org.junit.Test
import kotlinx.coroutines.test.runTest
import org.mockito.Mockito


class MainViewModelShould {

    private val gameRepository: GamesRepository = mock()

    private val getGamesUseCase = GetGamesUseCase(gameRepository)

    private val addGameUseCase = AddGameUseCase(gameRepository)

    private val updateGameUseCase = UpdateGameUseCase(gameRepository)

    private val useCases = GamesUseCases(
        getGamesUseCase = getGamesUseCase,
        addGameUseCase = addGameUseCase,
        updateGameUseCase = updateGameUseCase
    )


    @Test
    fun test_mainViewModel_shouldExist() = runTest {

        var viewModel = MainViewModel(
            useCases
        )

        assert(viewModel != null)
    }

    @Test
    fun test_mainViewModel_shouldRunAnReturnGamesLiveDataNull() {
        var viewModel = MainViewModel(
            useCases
        )
        val games = viewModel.gamesLiveData.value

        assertEquals(games, null)
    }

    @Test
    fun test_mainViewModel_shouldRunAnReturnGamesRatingLiveDataNull() {
        var viewModel = MainViewModel(
            useCases
        )
        val games = viewModel.gamesRatingLiveData.value

        assertEquals(games, null)
    }

    @Test
    fun test_mainViewModel_shouldRunAnReturngGamesRatingLiveDataNull() {
        var viewModel = MainViewModel(
            useCases
        )
        val games = viewModel.gamesRatingLiveData.value

        assertEquals(games, null)
    }

    @Test
    fun test_mainViewModel_shouldRunAnReturnGamesRatingByWonLiveDataNull() {
        var viewModel = MainViewModel(
            useCases
        )
        val games = viewModel.gamesRatingByWonLiveData.value

        assertEquals(games, null)
    }
}