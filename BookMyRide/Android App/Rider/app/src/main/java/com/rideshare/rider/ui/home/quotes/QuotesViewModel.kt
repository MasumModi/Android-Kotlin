package com.rideshare.rider.ui.home.quotes

import androidx.lifecycle.ViewModel
import com.rideshare.rider.data.repositories.QuotesRepository
import com.rideshare.rider.util.lazyDeferred

class QuotesViewModel(
    repository: QuotesRepository
) : ViewModel() {

    val quotes by lazyDeferred {
        repository.getQuotes()
    }

}