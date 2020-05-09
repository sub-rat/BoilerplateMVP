package com.subratgyawali.boilerplatemvp.domain.repository

import com.subratgyawali.boilerplatemvp.domain.model.UserRequestModel
import com.subratgyawali.boilerplatemvp.domain.model.UserResponseModel
import com.subratgyawali.boilerplatemvp.domain.model.UsersProfileModel
import io.reactivex.Observable

interface UserRepository {
    interface Local{
        fun getUser(): Observable<UserResponseModel>
    }

    interface Remote {
        fun authenticate(user: UserRequestModel): Observable<UserResponseModel>
    }
}