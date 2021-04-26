package com.mm.daggerapplication.daggerModule

import com.mm.daggerapplication.daggerComponents.Engine
import com.mm.daggerapplication.models.PetrolEngine
import dagger.Module
import dagger.Provides

@Module
class PetrolEngineModule {

    @Provides
    fun providePetrolEngine(powerCapacity: Int, engineCapacity: Int): Engine {
        return PetrolEngine(powerCapacity, engineCapacity)
    }
}