package com.roksidark.foosballmatchesapplication.data.model.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
    var date: Long,
    var firstPerson: String,
    var firstPersonScore: Int,
    var secondPerson: String,
    var secondPersonScore: Int
): Parcelable
