package com.bookmyride.rider.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.bookmyride.rider.R
import com.bookmyride.rider.data.db.entities.User
import com.bookmyride.rider.data.repositories.UserRepository
import com.bookmyride.rider.databinding.ActivitySignupBinding
import com.bookmyride.rider.ui.home.HomeActivity
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class SignupActivity : AppCompatActivity(), AuthListener, KodeinAware {

    override val kodein by kodein()
    private val repository: UserRepository by instance()
    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup)

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