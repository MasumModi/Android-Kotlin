package com.rideshare.rider.data.network.responses

import com.rideshare.rider.data.db.entities.User

data class AuthResponse(
    val isSuccessful: Boolean?,
    val message: String?,
    val user: User?
)