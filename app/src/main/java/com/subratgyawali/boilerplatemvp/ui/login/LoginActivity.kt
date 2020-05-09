package com.subratgyawali.boilerplatemvp.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.subratgyawali.boilerplatemvp.R
import com.subratgyawali.boilerplatemvp.base.BaseActivity
import com.subratgyawali.boilerplatemvp.databinding.ActivityLoginBinding
import com.subratgyawali.boilerplatemvp.domain.model.UserResponseModel

class LoginActivity : BaseActivity<ActivityLoginBinding>(), LoginPageContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun layout(): Int {
        return R.layout.activity_login
    }

    override fun onError(error: String) {
        TODO("Not yet implemented")
    }

    override fun onLoginSuccess(userResponse: UserResponseModel) {
        TODO("Not yet implemented")
    }

    override fun onNetworkError(networkError: String) {
        TODO("Not yet implemented")
    }

    override fun onForgotPasswordRequestSuccess(message: String) {
        TODO("Not yet implemented")
    }
}
