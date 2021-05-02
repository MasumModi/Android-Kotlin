package com.example.mvvmsample.ui.home.quotes

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.mvvmsample.data.repositories.QuotesRepository
import com.example.mvvmsample.util.ApiExceptions
import com.example.mvvmsample.util.NoInternetException
import com.example.mvvmsample.util.lazyDeferred
import java.io.IOException

class QuotesViewModel(
    repository: QuotesRepository
) : ViewModel() {

    val quotes by lazyDeferred {
        repository.getQuotes()
    }

}