package com.mm.daggerapplication.models

import com.mm.daggerapplication.daggerComponents.Engine
import javax.inject.Inject

class PetrolEngine : Engine {

    @Inject
    constructor(){

    }

    override fun start() {
        println("Petrol engine started...")
    }
}