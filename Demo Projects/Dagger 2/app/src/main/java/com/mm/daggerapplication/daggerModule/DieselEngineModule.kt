package com.mm.daggerapplication.daggerModule

import com.mm.daggerapplication.daggerComponents.Engine
import com.mm.daggerapplication.models.DieselEngine
import com.mm.daggerapplication.models.PetrolEngine
import dagger.Module
import dagger.Provides

@Module
class DieselEngineModule {

    @Provides
    fun provideDieselEngine(dieselEngine: DieselEngine) : Engine {
        return dieselEngine
    }

}