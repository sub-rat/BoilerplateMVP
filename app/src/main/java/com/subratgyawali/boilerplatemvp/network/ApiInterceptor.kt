package com.subratgyawali.boilerplatemvp.network

import android.content.Context
import com.subratgyawali.boilerplatemvp.utils.Constants
import com.subratgyawali.boilerplatemvp.utils.checkNetworkAvailability
import com.subratgyawali.boilerplatemvp.data.pref.SharedPreferenceManager
import com.subratgyawali.boilerplatemvp.exceptions.NetworkNotAvailableException
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import javax.inject.Inject

class ApiInterceptor @Inject constructor(
    val context: Context,
    private val sharedPreference: SharedPreferenceManager,
    private val refreshTokenService: RefreshTokenService
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!checkNetworkAvailability(context)) {
            throw NetworkNotAvailableException()
        }

        synchronized(this) {
            val requestBuilder = chain.request().newBuilder()
            if (!sharedPreference.accessToken.isEmpty()) {
                requestBuilder.addHeader("Authorization", sharedPreference.accessToken)
            }
            val response = chain.proceed(requestBuilder.build())
            val responseBody = response.body
            val responseString = responseBody?.string()
            return if (sharedPreference.accessToken.isNotEmpty() && response.code == Constants.TOKEN_EXPIRED) {
                val newToken = refreshTokenService.invalidateAccessToken()
                requestBuilder.removeHeader("Authorization")
                requestBuilder.addHeader("Authorization", newToken)
                chain.proceed(requestBuilder.build())
            } else {
                val contentType = responseBody?.contentType()
                response.newBuilder().body(responseString!!.toResponseBody(contentType))
                    .build()
            }
        }
    }
}