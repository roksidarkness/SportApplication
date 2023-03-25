package com.roksidark.foosballmatchesapplication.data.model.entity

data class ItemResultGame(
    val date: Long,
    val firstPerson: String,
    val firstScore: Int,
    val secondPerson: String,
    val secondScore: Int
)