package com.rideshare.rider.data.network.responses

import com.rideshare.rider.data.db.entities.Quote

data class QuoteResponse(
    val isSuccessful: Boolean,
    val quotes: List<Quote>
)