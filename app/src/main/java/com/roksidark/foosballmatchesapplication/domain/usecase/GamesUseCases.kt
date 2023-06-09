package com.roksidark.foosballmatchesapplication.domain.usecase

data class GamesUseCases (
    val getGamesUseCase: GetGamesUseCase,
    val addGameUseCase: AddGameUseCase,
    val updateGameUseCase: UpdateGameUseCase
)