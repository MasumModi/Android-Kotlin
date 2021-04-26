package com.mm.daggerapplication.daggerModule

import com.mm.daggerapplication.daggerComponents.Engine
import com.mm.daggerapplication.models.PetrolEngine
import dagger.Module
import dagger.Provides

@Module
class PetrolEngineModule {

    var powerCapacity: Int

    constructor(powerCapacity: Int) {
        this.powerCapacity = powerCapacity
    }

    @Provides
    fun providePetrolEngine(): Engine {
        return PetrolEngine(powerCapacity)
    }
}