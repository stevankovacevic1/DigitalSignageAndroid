package com.consulteer.digital_signage.view.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.consulteer.digital_signage.R
import com.consulteer.digital_signage.data.db.entities.User
import com.consulteer.digital_signage.databinding.ActivityLoginBinding
import com.consulteer.digital_signage.utill.hide
import com.consulteer.digital_signage.utill.show
import com.consulteer.digital_signage.utill.snackbar
import com.consulteer.digital_signage.view.ui.home.HomeActivityFeed
import kotlinx.android.synthetic.main.activity_login.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class LoginActivity : AppCompatActivity(), AuthListener, KodeinAware{

    override val kodein by kodein()
    private val factory: AuthViewModelFactory by instance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val networkConnectionInterceptor = NetworkConnectionInterceptor(this)
//        val api = MyApi(networkConnectionInterceptor)
//        val db = AppDatabase(this)
//        val repository = UserRepository(api, db)
//        val factory = AuthViewModelFactory(repository)
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this, factory).get(AuthViewModel::class.java)

        binding.viewmodel = viewModel
        viewModel.authListener = this
        viewModel.getLoggedInUser().observe(this, Observer { user ->
            if (user != null) {// to not to return to userlogin, because it is not good practice
                Intent(this, HomeActivityFeed::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }

            }
        })
    }

    override fun onStarted() {
        //toast("login Started")
        progressBarStarted.show()
        progressBarStarted.visibility = View.VISIBLE

    }

    override fun onSuccess(user: User) {
        progressBarStarted.hide()
        login_layout.snackbar("welcome ${user.firstName} to the Digital Signage")
        //toast("${user.firstName} is logged in")
    }

    override fun onFailure(message: String) {
        progressBarStarted.hide()
        login_layout.snackbar(message)
        //toast(message)

    }
}

