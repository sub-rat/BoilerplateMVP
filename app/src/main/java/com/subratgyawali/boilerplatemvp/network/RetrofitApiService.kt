package com.subratgyawali.boilerplatemvp.network

import com.subratgyawali.boilerplatemvp.domain.model.UserRequestModel
import com.subratgyawali.boilerplatemvp.domain.model.UserResponseModel
import io.reactivex.Observable
import retrofit2.http.*

interface RetrofitApiService {

    @POST("login")
    fun login(@Body userRequestModel: UserRequestModel): Observable<BaseResponse<UserResponseModel>>

}