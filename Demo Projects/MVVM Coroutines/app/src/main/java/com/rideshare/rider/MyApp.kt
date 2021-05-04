package com.rideshare.rider

import android.app.Application
import com.rideshare.rider.data.db.AppDatabase
import com.rideshare.rider.data.network.MyApi
import com.rideshare.rider.data.network.NetworkConnectionInterceptor
import com.rideshare.rider.data.preferences.PreferenceProvider
import com.rideshare.rider.data.repositories.QuotesRepository
import com.rideshare.rider.data.repositories.UserRepository
import com.rideshare.rider.ui.auth.AuthViewModel
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