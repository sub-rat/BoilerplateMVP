package com.subratgyawali.boilerplatemvp.ui.login

import com.subratgyawali.boilerplatemvp.base.BasePresenterImpl
import com.subratgyawali.boilerplatemvp.domain.model.UserRequestModel
import com.subratgyawali.boilerplatemvp.domain.model.UserResponseModel
import com.subratgyawali.boilerplatemvp.domain.repository.UserRepository
import com.subratgyawali.boilerplatemvp.ui.login.LoginPageContract
import com.subratgyawali.boilerplatemvp.utils.ApiError
import javax.inject.Inject

class LoginPagePresenter @Inject constructor(
    private val view: LoginPageContract.View,
    private val localRepository: UserRepository.Local,
    private val remoteRepository: UserRepository.Remote): BasePresenterImpl(), LoginPageContract.Presenter {

    override fun stop() {
        compositeDisposable.dispose()
    }

    override fun authenticate(user: UserRequestModel) {
        compositeDisposable.add(remoteRepository.authenticate(user)
                .subscribe(
                        {
                            view.onLoginSuccess(it)
                        },
                        {
                            view.onError(ApiError(it).message)
                        }
                )
        )
    }

    override fun forgotPassword(email: String) {
       // ToDo implement forget password
    }

    override fun getUser() {
        disposable = localRepository.getUser().subscribe(
            {
                //ToDo on user get
            },
            {
                view.onError(ApiError(it).message)
            })
    }


}