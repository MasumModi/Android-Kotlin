package com.bookmyride.rider.ui.home.quotes

import androidx.lifecycle.ViewModel
import com.bookmyride.rider.data.repositories.QuotesRepository
import com.bookmyride.rider.util.lazyDeferred

class QuotesViewModel(
    repository: QuotesRepository
) : ViewModel() {

    val quotes by lazyDeferred {
        repository.getQuotes()
    }

}