package com.bookmyride.rider.ui.auth

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import com.bookmyride.rider.data.repositories.UserRepository
import com.bookmyride.rider.util.ApiExceptions
import com.bookmyride.rider.util.Coroutines
import com.bookmyride.rider.util.NoInternetException
import java.io.IOException

class AuthViewModel(
    private val repository: UserRepository
) : ViewModel() {

    var name: String? = null
    var email: String? = null
    var password: String? = null
    var passwordConfirmed: String? = null
    var authListener: AuthListener? = null

    fun getLoggedInUser() = repository.getUser()

    fun onLoginButtonClick(view: View) {
        authListener?.onStarted()

        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Invalid email or password")
            return
        }

        Coroutines.main {
            try {
                val response = repository.userLogin(email!!, password!!)
                response.user?.let {
                    authListener?.onSuccess(it)
                    repository.saveUser(it)
                    return@main
                }
                authListener?.onFailure(response.message!!)
            } catch (e: ApiExceptions) {
                authListener?.onFailure(e.message!!)
            } catch (e: NoInternetException) {
                authListener?.onFailure(e.message!!)
            } catch (e: IOException) {
                authListener?.onFailure(e.message!!)
                Log.d(TAG,e.message!!)
            }
        }
    }

    fun onSignup(view: View) {
        Intent(view.context, SignupActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

    fun onSignIn(view: View) {
        Intent(view.context, LoginActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

    fun onSignupButtonClick(view: View) {
        authListener?.onStarted()

        if (name.isNullOrEmpty()) {
            authListener?.onFailure("Name is required")
            return
        }

        if (email.isNullOrEmpty()) {
            authListener?.onFailure("Email is required")
            return
        }

        if (password.isNullOrEmpty()) {
            authListener?.onFailure("Please enter a password")
            return
        }

        if (password != passwordConfirmed) {
            authListener?.onFailure("Confirm password does not match")
            return
        }

        Coroutines.main {
            try {
                val response = repository.userSignup(name!!, email!!, password!!)
                response.user?.let {
                    authListener?.onSuccess(it)
                    repository.saveUser(it)
                    return@main
                }
                authListener?.onFailure(response.message!!)
            } catch (e: ApiExceptions) {
                authListener?.onFailure(e.message!!)
            } catch (e: NoInternetException) {
                authListener?.onFailure(e.message!!)
            }
        }
    }

    companion object {
        private const val TAG = "AuthViewModel:"
    }

}