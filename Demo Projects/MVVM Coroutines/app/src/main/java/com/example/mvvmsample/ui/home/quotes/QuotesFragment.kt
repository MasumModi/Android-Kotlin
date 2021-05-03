package com.example.mvvmsample.ui.home.quotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.mvvmsample.R
import com.example.mvvmsample.data.repositories.QuotesRepository
import com.example.mvvmsample.util.Coroutines
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class QuotesFragment : Fragment(), KodeinAware {

    override val kodein by kodein()
    private val repository: QuotesRepository by instance()

    private lateinit var viewModel: QuotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.quotes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = QuotesViewModel(repository)
        bindUI()
    }

    private fun bindUI() = Coroutines.main {
        viewModel.quotes.await().observe(viewLifecycleOwner, Observer {
            initRecyclerView()
        })
    }

    private fun initRecyclerView() {


    }

}