package com.mm.daggerapplication.models

import com.mm.daggerapplication.daggerComponents.Engine
import javax.inject.Inject

class Car {
    @Inject
    lateinit var wheels: Wheels
    lateinit var engine: Engine

    @Inject
    constructor(engine: Engine) {
        this.engine = engine
    }

    @Inject
    fun provideCarToRemote(remote: Remote){
        remote.provideCar(this)
    }

    fun drive() {
        println("wheels: $wheels")
        engine.start()
        println("Driving...")
    }
}