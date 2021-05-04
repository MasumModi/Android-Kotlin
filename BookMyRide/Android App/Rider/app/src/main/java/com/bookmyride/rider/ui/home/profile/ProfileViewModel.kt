package com.bookmyride.rider.ui.home.profile

import androidx.lifecycle.ViewModel
import com.bookmyride.rider.data.repositories.UserRepository

class ProfileViewModel(
    repository: UserRepository
) : ViewModel() {
    val user = repository.getUser()
}