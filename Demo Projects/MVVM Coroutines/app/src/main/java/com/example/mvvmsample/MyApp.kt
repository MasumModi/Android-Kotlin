package com.example.mvvmsample

import android.app.Application
import com.example.mvvmsample.data.db.AppDatabase
import com.example.mvvmsample.data.network.MyApi
import com.example.mvvmsample.data.network.NetworkConnectionInterceptor
import com.example.mvvmsample.data.preferences.PreferenceProvider
import com.example.mvvmsample.data.repositories.QuotesRepository
import com.example.mvvmsample.data.repositories.UserRepository
import com.example.mvvmsample.ui.auth.AuthViewModel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MyApp : Application(), KodeinAware {

    override val kodein = Kodein.lazy {

        import(androidXModule(this@MyApp))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { PreferenceProvider(instance()) }
        bind() from singleton { UserRepository(instance(), instance()) }
        bind() from singleton { QuotesRepository(instance(), instance(), instance()) }
        bind() from provider { AuthViewModel(instance()) }

    }

}