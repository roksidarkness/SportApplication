package com.roksidark.foosballmatchesapplication.di.component

import com.roksidark.foosballmatchesapplication.FoosballApp
import com.roksidark.foosballmatchesapplication.di.module.AppModule
import com.roksidark.foosballmatchesapplication.di.module.FragmentBuilder
import com.roksidark.foosballmatchesapplication.di.module.MainActivityModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        MainActivityModule::class,
        FragmentBuilder::class
    ]
)
interface AppComponent : AndroidInjector<FoosballApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: FoosballApp): Builder

        fun build(): AppComponent

    }

    override fun inject(app: FoosballApp)
}