package com.mm.daggerapplication.models

import com.mm.daggerapplication.daggerComponents.Engine
import javax.inject.Inject

class DieselEngine : Engine {

    @Inject
    constructor(){

    }

    override fun start() {
        println("Diesel engine started")
    }
}