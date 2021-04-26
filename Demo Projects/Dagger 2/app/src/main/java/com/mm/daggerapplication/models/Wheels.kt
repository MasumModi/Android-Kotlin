package com.mm.daggerapplication.models

class Wheels {

    lateinit var rims: Rims
    lateinit var tires: Tires

    constructor(rims: Rims, tires: Tires) {
        this.rims = rims
        this.tires = tires
    }
}