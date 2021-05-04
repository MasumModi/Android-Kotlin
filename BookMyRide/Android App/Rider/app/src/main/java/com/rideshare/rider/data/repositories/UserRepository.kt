package com.rideshare.rider.data.repositories

import com.rideshare.rider.data.db.AppDatabase
import com.rideshare.rider.data.db.entities.User
import com.rideshare.rider.data.network.MyApi
import com.rideshare.rider.data.network.SafeApiRequest
import com.rideshare.rider.data.network.responses.AuthResponse

class UserRepository(
    private val api: MyApi,
    private val db: AppDatabase
) : SafeApiRequest() {

    suspend fun userLogin(email: String, password: String): AuthResponse {
        return apiRequest { api.userLogin(email, password) }
    }

    suspend fun userSignup(name: String, email: String, password: String): AuthResponse {
        return apiRequest { api.userSignup(name, email, password) }
    }

    suspend fun saveUser(user: User) = db.getUserDao().insertUser(user)

    fun getUser() = db.getUserDao().getUser()
}