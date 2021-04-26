package com.mm.daggerapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mm.daggerapplication.daggerComponents.CarComponent
import com.mm.daggerapplication.daggerComponents.DaggerCarComponent
import com.mm.daggerapplication.models.Car

class MainActivity : AppCompatActivity() {

    lateinit var car: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        car = DaggerCarComponent.create().getCar()
        car.drive()
    }
}