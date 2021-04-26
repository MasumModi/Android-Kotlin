package com.mm.daggerapplication.models

import javax.inject.Inject

class Remote {

    lateinit var car: Car

    @Inject
    constructor() {

    }

    fun provideCar(car: Car) {
        this.car = car
    }

}