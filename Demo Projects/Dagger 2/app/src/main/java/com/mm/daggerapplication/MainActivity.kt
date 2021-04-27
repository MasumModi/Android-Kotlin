package com.mm.daggerapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
        val carComponent = (application as MyApp).carComponent()
        carComponent.inject(this)
        car.drive()
        car1.drive()
    }
}