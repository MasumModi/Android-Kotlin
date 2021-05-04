package com.rideshare.rider.ui.auth

import com.rideshare.rider.data.db.entities.User

interface AuthListener {
    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message: String)
}