package com.mm.daggerapplication

import android.app.Application
import com.mm.daggerapplication.daggerComponents.CarComponent
import com.mm.daggerapplication.daggerComponents.DaggerCarComponent

class MyApp : Application() {

    lateinit var carComponent: CarComponent

    override fun onCreate() {
        super.onCreate()

        carComponent = DaggerCarComponent.builder()
            .powerCapacity(300)
            .engineCapacity(1000)
            .build()

    }

    fun carComponent(): CarComponent {
        return carComponent
    }

}