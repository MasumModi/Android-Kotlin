package com.mm.daggerapplication.models

import com.mm.daggerapplication.daggerComponents.Engine
import javax.inject.Inject

class Car {
    @Inject
    lateinit var wheels: Wheels
    lateinit var engine: Engine
    lateinit var driver: Driver

    @Inject
    constructor(engine: Engine, driver: Driver) {
        this.engine = engine
        this.driver = driver
    }

    @Inject
    fun provideCarToRemote(remote: Remote){
        remote.provideCar(this)
    }

    fun drive() {
        //println("Driver: $driver")
        //println("wheels: $wheels")
        engine.start()
        //println("Driving...")
    }
}