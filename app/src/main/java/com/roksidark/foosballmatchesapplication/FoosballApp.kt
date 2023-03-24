package com.roksidark.foosballmatchesapplication

import android.app.Application
import com.roksidark.foosballmatchesapplication.di.DaggerApplicationComponent

class FoosballApp: Application() {
    val appComponent = DaggerApplicationComponent.create()
}