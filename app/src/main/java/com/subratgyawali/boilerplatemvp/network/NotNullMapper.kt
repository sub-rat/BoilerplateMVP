package com.subratgyawali.boilerplatemvp.network

import com.subratgyawali.boilerplatemvp.exceptions.FailedResponseException
import io.reactivex.Observable
import io.reactivex.annotations.NonNull
import io.reactivex.functions.Function

class NotNullMapper<T> : Function<BaseResponse<T>, Observable<T>> {
    @Throws(Exception::class)
    override fun apply(@NonNull baseResponse: BaseResponse<T>): Observable<T> {

        if (!baseResponse.status)
            return Observable.error(
                FailedResponseException(baseResponse.statusMessage.toString())
            )

        val item = baseResponse.response
        return if (item == null)
            Observable.error(NullPointerException("Server Error"))
        else
            Observable.just(item)
    }
}