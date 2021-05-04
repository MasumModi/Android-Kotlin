package com.bookmyride.rider.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bookmyride.rider.data.db.AppDatabase
import com.bookmyride.rider.data.db.entities.Quote
import com.bookmyride.rider.data.network.MyApi
import com.bookmyride.rider.data.network.SafeApiRequest
import com.bookmyride.rider.data.preferences.PreferenceProvider
import com.bookmyride.rider.util.Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

private const val MINIMUM_INTERVAL = 6

class QuotesRepository(
    private val api: MyApi,
    private val db: AppDatabase,
    private val pref: PreferenceProvider
) : SafeApiRequest() {
    private val quotes = MutableLiveData<List<Quote>>()

    init {
        quotes.observeForever {
            saveQuotes(it)
        }
    }

    companion object {
        private const val TAG = "QuotesRepository: "
    }

    suspend fun getQuotes(): LiveData<List<Quote>> {
        return withContext(Dispatchers.IO) {
            fetchQuotes()
            db.getQuoteDao().getQuotes()
        }
    }

    private suspend fun fetchQuotes() {
        val lastSavedAt = pref.getLastSavedAt()
        if (lastSavedAt == null || isFetchNeeded(LocalDateTime.parse(lastSavedAt))) {
            val response = apiRequest { api.getQuotes() }
            quotes.postValue(response.quotes)
        }
    }

    private fun isFetchNeeded(savedAt: LocalDateTime): Boolean {
        return ChronoUnit.HOURS.between(savedAt, LocalDateTime.now()) > MINIMUM_INTERVAL
    }

    private fun saveQuotes(quotes: List<Quote>) {
        Coroutines.io {
            pref.saveLastSavedAt(LocalDateTime.now().toString())
            db.getQuoteDao().saveAllQuotes(quotes)
        }
    }
}