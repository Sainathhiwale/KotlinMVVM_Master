package com.examen.kotlinmvvm_master.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.examen.kotlinmvvm_master.R
import com.examen.kotlinmvvm_master.databinding.ActivityLoginBinding
import com.examen.kotlinmvvm_master.data.utils.Network
import com.examen.kotlinmvvm_master.data.utils.Utils.validateLoginRequest
import com.examen.kotlinmvvm_master.presentation.MainActivity
import com.examen.kotlinmvvm_master.presentation.viewmodel.LoginViewModel

import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private val TAG = LoginActivity::class.simpleName
    @Inject
    lateinit var viewModel: LoginViewModel

    private lateinit var loginBinding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)

        initView()
    }

    private fun initView() {

        loginBinding.loginButton.setOnClickListener(this)
        loginBinding.loginSignup.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.login_button ->{
                if (Network.isNetworkAvailable(this)){
                    if (checkValidation()){
                        loginUser()
                    }else{
                        Snackbar.make(loginBinding.constraintLogin,"Username Password cannot be blank ",
                            Snackbar.LENGTH_SHORT).show()
                    }

                }else{
                    Snackbar.make(loginBinding.constraintLogin,"No Internet Connection",
                        Snackbar.LENGTH_SHORT).show()
                }

            }
            R.id.login_signup ->{
                navigateSignUpScreen()
            }
        }
    }

    private fun checkValidation(): Boolean {
        if ( loginBinding.loginUsername.editableText.toString().isBlank() && loginBinding.loginPassword.editableText.toString().isBlank()){
          return false
        }
        return true
    }

    private fun navigateSignUpScreen() {
        Snackbar.make(loginBinding.constraintLogin,"Coming soon",
            Snackbar.LENGTH_SHORT).show()
    }

    private fun loginUser() {
        val username = loginBinding.loginUsername.editableText.toString()
        val password = loginBinding.loginPassword.editableText.toString()
        val result = validateLoginRequest(username, password)

        if (result.successful){
            loginBinding.loginProgress.visibility = View.VISIBLE
            loginBinding.loginButton.isEnabled = false

            viewModel.loginUser(username, password)

            viewModel.successful.observe(this){successful ->
                if (successful == true){
                    Log.d(TAG, "loginUser: " )
                    loginBinding.loginProgress.visibility = View.INVISIBLE
                    loginBinding.loginButton.isEnabled = true
                    navigatedMain()

                }else if(successful == false){
                    loginBinding.loginProgress.visibility = View.INVISIBLE
                    loginBinding.loginButton.isEnabled = true
                    Snackbar.make(loginBinding.loginButton,"${viewModel.error.value}",Snackbar.LENGTH_SHORT).show()
                    //viewModel.navigated()
                }
            }
        }
        else{
            Snackbar.make(loginBinding.loginButton,"${result.error}",Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun navigatedMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}