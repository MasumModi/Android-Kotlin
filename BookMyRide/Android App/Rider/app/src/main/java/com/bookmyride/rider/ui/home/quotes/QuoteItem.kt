package com.bookmyride.rider.ui.home.quotes

import com.bookmyride.rider.R
import com.bookmyride.rider.data.db.entities.Quote
import com.bookmyride.rider.databinding.ItemQuoteBinding
import com.xwray.groupie.databinding.BindableItem

class QuoteItem(
    private val quote: Quote
) : BindableItem<ItemQuoteBinding>() {

    override fun bind(viewBinding: ItemQuoteBinding, position: Int) {
        viewBinding.quote = quote
    }

    override fun getLayout() = R.layout.item_quote

}