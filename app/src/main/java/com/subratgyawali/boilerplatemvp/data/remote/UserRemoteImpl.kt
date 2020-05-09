package com.subratgyawali.boilerplatemvp.data.remote

import com.subratgyawali.boilerplatemvp.data.pref.SharedPreferenceManager
import com.subratgyawali.boilerplatemvp.domain.model.UserRequestModel
import com.subratgyawali.boilerplatemvp.domain.model.UserResponseModel
import com.subratgyawali.boilerplatemvp.domain.repository.UserRepository
import com.subratgyawali.boilerplatemvp.network.NotNullMapper
import com.subratgyawali.boilerplatemvp.network.RetrofitApiService
import com.subratgyawali.boilerplatemvp.utils.SchedulersFactory
import io.reactivex.Observable
import javax.inject.Inject

class UserRemoteImpl @Inject constructor(
    private var apiService: RetrofitApiService,
    private var sharedPreferenceManager: SharedPreferenceManager,
    private var schedulersFactory: SchedulersFactory
) : UserRepository.Remote {
    override fun authenticate(user: UserRequestModel): Observable<UserResponseModel> {
        return apiService.login(user)
            .flatMap(NotNullMapper())
            .subscribeOn(schedulersFactory.io())
            .doOnNext {
                sharedPreferenceManager.saveUser(it)
            }
            .observeOn(schedulersFactory.ui())

    }
}