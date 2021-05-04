package com.bookmyride.rider.ui.auth

import com.bookmyride.rider.data.db.entities.User

interface AuthListener {
    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message: String)
}