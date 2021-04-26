package com.mm.daggerapplication.daggerComponents

import android.app.Activity
import com.mm.daggerapplication.MainActivity
import com.mm.daggerapplication.models.Car
import dagger.Component

@Component
interface CarComponent {
    fun getCar(): Car

    fun inject(mainActivity: MainActivity)
}