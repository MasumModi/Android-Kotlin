package com.mm.daggerapplication.models

import com.mm.daggerapplication.daggerComponents.Engine
import javax.inject.Inject
import javax.inject.Named

class PetrolEngine : Engine {

    var powerCapacity: Int
    var engineCapacity: Int

    @Inject
    constructor(@Named("power")powerCapacity: Int,@Named("engine")engineCapacity: Int) {
        this.powerCapacity = powerCapacity
        this.engineCapacity = engineCapacity
    }

    override fun start() {
        println("Petrol engine started with $powerCapacity power capacity and $engineCapacity engine capacity")
    }
}