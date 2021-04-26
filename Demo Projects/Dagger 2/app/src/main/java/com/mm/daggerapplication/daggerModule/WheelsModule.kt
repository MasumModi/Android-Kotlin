package com.mm.daggerapplication.daggerModule

import com.mm.daggerapplication.models.Rims
import com.mm.daggerapplication.models.Tires
import com.mm.daggerapplication.models.Wheels
import dagger.Module
import dagger.Provides

@Module
class WheelsModule {

    @Provides
    fun provideRims(): Rims {
        return Rims()
    }

    @Provides
    fun provideTires(): Tires {
        return Tires()
    }

    @Provides
    fun provideWheels(rims: Rims, tires: Tires): Wheels {
        return Wheels(rims, tires)
    }
}