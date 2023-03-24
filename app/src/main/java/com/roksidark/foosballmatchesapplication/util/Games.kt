package com.roksidark.foosballmatchesapplication.util

import com.roksidark.foosballmatchesapplication.data.model.entity.ItemResult

val finishedGames = mutableListOf(
    ItemResult(System.currentTimeMillis(), "Amos", 4, "Diego",  5),
    ItemResult(System.currentTimeMillis(), "Amos", 1,"Diego", 5),
    ItemResult(System.currentTimeMillis(), "Amos", 2,"Diego", 5),
    ItemResult(System.currentTimeMillis(), "Amos", 0,"Diego",  5),
    ItemResult(System.currentTimeMillis(), "Amos", 6,"Diego",  5),
    ItemResult(System.currentTimeMillis(), "Amos", 5,"Diego",  2),
    ItemResult(System.currentTimeMillis(), "Amos", 4,"Diego",  0),
    ItemResult(System.currentTimeMillis(), "Joel", 4,"Diego", 5),
    ItemResult(System.currentTimeMillis(), "Tim", 4,"Amos",  5),
    ItemResult(System.currentTimeMillis(), "Tim", 5,"Amos", 2),
    ItemResult(System.currentTimeMillis(), "Amos", 3,"Tim", 5),
    ItemResult(System.currentTimeMillis(), "Amos", 5,"Tim", 3),
    ItemResult(System.currentTimeMillis(), "Amos", 5,"Joel", 4),
    ItemResult(System.currentTimeMillis(), "Joel", 5,"Tim", 2),
)