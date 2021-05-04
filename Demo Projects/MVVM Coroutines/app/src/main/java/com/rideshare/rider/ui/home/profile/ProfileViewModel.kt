package com.rideshare.rider.ui.home.profile

import androidx.lifecycle.ViewModel
import com.rideshare.rider.data.repositories.UserRepository

class ProfileViewModel(
    repository: UserRepository
) : ViewModel() {
    val user = repository.getUser()
}