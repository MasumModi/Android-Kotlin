package com.mm.daggerapplication.models

import com.mm.daggerapplication.daggerComponents.Engine
import javax.inject.Inject

class PetrolEngine : Engine {

    var powerCapacity: Int

    @Inject
    constructor(powerCapacity: Int){
        this.powerCapacity = powerCapacity
    }

    override fun start() {
        println("Petrol engine started with $powerCapacity power capacity")
    }
}