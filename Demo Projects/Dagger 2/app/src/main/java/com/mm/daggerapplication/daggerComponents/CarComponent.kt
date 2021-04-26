package com.mm.daggerapplication.daggerComponents

import com.mm.daggerapplication.MainActivity
import com.mm.daggerapplication.daggerModule.DieselEngineModule
import com.mm.daggerapplication.daggerModule.PetrolEngineModule
import com.mm.daggerapplication.models.Car
import dagger.Component

@Component(modules = [PetrolEngineModule::class])
interface CarComponent {
    fun getCar(): Car
    fun inject(mainActivity: MainActivity)
}