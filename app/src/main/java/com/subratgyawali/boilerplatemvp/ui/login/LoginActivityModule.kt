package com.subratgyawali.boilerplatemvp.ui.login

import com.subratgyawali.boilerplatemvp.data.remote.UserLocalImpl
import com.subratgyawali.boilerplatemvp.data.remote.UserRemoteImpl
import com.subratgyawali.boilerplatemvp.di.scope.PerActivity
import com.subratgyawali.boilerplatemvp.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class LoginActivityModule {

    @PerActivity
    @Provides
    internal fun provideLoginActivity(loginActivity: LoginActivity) : LoginPageContract.View {
        return loginActivity
    }

    @PerActivity
    @Provides
    internal fun provideLoginPresenter(view: LoginPageContract.View, localRepo:UserLocalImpl,remoteRepo:UserRemoteImpl ) : LoginPageContract.Presenter {
        return LoginPagePresenter(view, localRepo, remoteRepo)
    }


}