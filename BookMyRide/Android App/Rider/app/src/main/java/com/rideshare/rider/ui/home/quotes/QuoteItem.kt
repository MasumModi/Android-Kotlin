package com.rideshare.rider.ui.home.quotes

import com.rideshare.rider.R
import com.rideshare.rider.data.db.entities.Quote
import com.rideshare.rider.databinding.ItemQuoteBinding
import com.xwray.groupie.databinding.BindableItem

class QuoteItem(
    private val quote: Quote
) : BindableItem<ItemQuoteBinding>() {

    override fun bind(viewBinding: ItemQuoteBinding, position: Int) {
        viewBinding.quote = quote
    }

    override fun getLayout() = R.layout.item_quote

}