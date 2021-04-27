package com.mm.daggerapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mm.daggerapplication.daggerComponents.CarComponent
import com.mm.daggerapplication.daggerComponents.DaggerCarComponent
import com.mm.daggerapplication.daggerModule.PetrolEngineModule
import com.mm.daggerapplication.models.Car
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var car: Car

    @Inject
    lateinit var car1: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val carComponent = DaggerCarComponent.builder()
            .powerCapacity(300)
            .engineCapacity(1000)
            .build()

        carComponent.inject(this)

        car.drive()
        car1.drive()
    }

}