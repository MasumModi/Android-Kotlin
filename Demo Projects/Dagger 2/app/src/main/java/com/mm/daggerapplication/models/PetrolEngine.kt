package com.mm.daggerapplication.models

import com.mm.daggerapplication.daggerComponents.Engine
import javax.inject.Inject

class PetrolEngine : Engine {

    var powerCapacity: Int
    var engineCapacity: Int

    @Inject
    constructor(powerCapacity: Int, engineCapacity: Int) {
        this.powerCapacity = powerCapacity
        this.engineCapacity = engineCapacity
    }

    override fun start() {
        println("Petrol engine started with $powerCapacity power capacity and $engineCapacity engine capacity")
    }
}