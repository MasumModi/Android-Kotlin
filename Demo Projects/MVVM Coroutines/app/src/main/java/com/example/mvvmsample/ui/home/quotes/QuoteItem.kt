package com.example.mvvmsample.ui.home.quotes

import com.example.mvvmsample.R
import com.example.mvvmsample.data.db.entities.Quote
import com.example.mvvmsample.databinding.ItemQuoteBinding
import com.xwray.groupie.databinding.BindableItem

class QuoteItem(
    private val quote: Quote
) : BindableItem<ItemQuoteBinding>() {

    override fun bind(viewBinding: ItemQuoteBinding, position: Int) {
        viewBinding.quote = quote
    }

    override fun getLayout() = R.layout.item_quote

}