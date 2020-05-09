package com.subratgyawali.boilerplatemvp.data.remote

import com.subratgyawali.boilerplatemvp.data.pref.SharedPreferenceManager
import com.subratgyawali.boilerplatemvp.domain.model.UserRequestModel
import com.subratgyawali.boilerplatemvp.domain.model.UserResponseModel
import com.subratgyawali.boilerplatemvp.domain.repository.UserRepository
import com.subratgyawali.boilerplatemvp.utils.SchedulersFactory
import io.reactivex.Observable
import javax.inject.Inject


class UserLocalImpl @Inject constructor(
    var sharedPreferenceManager: SharedPreferenceManager,
    var schedulersFactory: SchedulersFactory
) : UserRepository.Local {
    override fun getUser(): Observable<UserResponseModel> {
        TODO("Not yet implemented")
    }
}