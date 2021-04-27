package com.mm.daggerapplication.daggerComponents

import com.mm.daggerapplication.MainActivity
import com.mm.daggerapplication.daggerModule.DieselEngineModule
import com.mm.daggerapplication.daggerModule.PetrolEngineModule
import com.mm.daggerapplication.daggerModule.WheelsModule
import com.mm.daggerapplication.models.Car
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

@Component(modules = [PetrolEngineModule::class, WheelsModule::class])
interface CarComponent {
    fun getCar(): Car
    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun powerCapacity(@Named("power")powerCapacity: Int): Builder

        @BindsInstance
        fun engineCapacity(@Named("engine")engineCapacity: Int): Builder

        fun build(): CarComponent

    }
}