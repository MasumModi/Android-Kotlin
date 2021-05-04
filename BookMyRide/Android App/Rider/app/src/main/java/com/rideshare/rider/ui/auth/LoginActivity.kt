package com.rideshare.rider.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.rideshare.rider.R
import com.rideshare.rider.data.db.entities.User
import com.rideshare.rider.data.repositories.UserRepository
import com.rideshare.rider.databinding.ActivityLoginBinding
import com.rideshare.rider.ui.home.HomeActivity
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class LoginActivity : AppCompatActivity(), AuthListener, KodeinAware {

    override val kodein by kodein()
    private val repository: UserRepository by instance()
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        val viewModel = AuthViewModel(repository)

        binding.viewModel = viewModel
        viewModel.authListener = this

        viewModel.getLoggedInUser().observe(this, Observer { user ->
            user?.let {
                Intent(this, HomeActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
            }
        })
    }

    override fun onStarted() {
        binding.progressBar.show()
    }

    override fun onSuccess(user: User) {
        binding.progressBar.hide()
    }

    override fun onFailure(message: String) {
        binding.progressBar.hide()
        binding.rootLayout.snackbar(message)
    }

}