package com.mm.daggerapplication.daggerModule

import com.mm.daggerapplication.daggerComponents.Engine
import com.mm.daggerapplication.models.PetrolEngine
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class PetrolEngineModule {
    @Binds
    abstract fun providePetrolEngine(petrolEngine: PetrolEngine) : Engine
}