package com.roksidark.foosballmatchesapplication

import com.roksidark.foosballmatchesapplication.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class FoosballApp: DaggerApplication() {
    private val applicationInjector = DaggerAppComponent
        .builder()
        .application(this)
        .build()

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = applicationInjector
}