package com.example.mvvmsample.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.mvvmsample.R
import com.example.mvvmsample.data.db.AppDatabase
import com.example.mvvmsample.data.db.entities.User
import com.example.mvvmsample.data.network.MyApi
import com.example.mvvmsample.data.repositories.UserRepository
import com.example.mvvmsample.databinding.ActivityLoginBinding
import com.example.mvvmsample.ui.home.HomeActivity
import com.example.mvvmsample.util.hide
import com.example.mvvmsample.util.show
import com.example.mvvmsample.util.snackbar
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val api = MyApi()
        val db = AppDatabase(this)
        val repository = UserRepository(api,db)

        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
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
        progress_bar.show()
    }

    override fun onSuccess(user: User) {
        progress_bar.hide()
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        root_layout.snackbar(message)
    }
}