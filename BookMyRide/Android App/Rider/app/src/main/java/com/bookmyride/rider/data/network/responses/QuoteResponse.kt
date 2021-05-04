package com.bookmyride.rider.data.network.responses

import com.bookmyride.rider.data.db.entities.Quote

data class QuoteResponse(
    val isSuccessful: Boolean,
    val quotes: List<Quote>
)