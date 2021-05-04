package com.bookmyride.rider.data.network.responses

import com.bookmyride.rider.data.db.entities.User

data class AuthResponse(
    val isSuccessful: Boolean?,
    val message: String?,
    val user: User?
)