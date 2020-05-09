package com.subratgyawali.boilerplatemvp.ui.login

import com.subratgyawali.boilerplatemvp.base.BasePresenter
import com.subratgyawali.boilerplatemvp.base.BaseView
import com.subratgyawali.boilerplatemvp.domain.model.UserRequestModel
import com.subratgyawali.boilerplatemvp.domain.model.UserResponseModel


interface LoginPageContract {
    interface View: BaseView {
        fun onError(error: String)
        fun onLoginSuccess(userResponse: UserResponseModel)
        fun onNetworkError(networkError: String)
        fun onForgotPasswordRequestSuccess(message: String)
    }

    interface Presenter: BasePresenter {
        fun authenticate(user: UserRequestModel)
        fun forgotPassword(email: String)
        fun getUser()
    }
}