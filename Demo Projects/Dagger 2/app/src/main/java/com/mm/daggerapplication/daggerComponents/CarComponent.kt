package com.mm.daggerapplication.daggerComponents

import com.mm.daggerapplication.models.Car
import dagger.Component

@Component
interface CarComponent {
    fun getCar(): Car
}