package com.subratgyawali.boilerplatemvp.network

import com.subratgyawali.boilerplatemvp.utils.Environment
import com.subratgyawali.boilerplatemvp.data.pref.SharedPreferenceManager
import com.subratgyawali.boilerplatemvp.exceptions.FailedResponseException
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import java.lang.Exception
import javax.inject.Inject

class RefreshTokenService @Inject constructor(private val sharedPreference: SharedPreferenceManager, private val httpLoggingInterceptor: HttpLoggingInterceptor) {

    fun invalidateAccessToken(): String {
        val mOkHttpClient = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()
        val request = Request.Builder()
            .url(Environment.getServerUrl() + "refreshToken")
            .addHeader("authorization", sharedPreference.accessToken)
            .get()
//            .post("UTF-8".toRequestBody("application/json".toMediaTypeOrNull()))
            .build()
        val newResponse: Response = mOkHttpClient.newCall(request).execute()
        val tokenResponse = newResponse.body?.string()
        try {
            val responseObject = JSONObject(tokenResponse).getJSONObject("data")
            val newToken = responseObject.getString("refresh_token")
            sharedPreference.accessToken = "Bearer $newToken"
            return "Bearer $newToken"
        }catch (e: Exception){
            throw FailedResponseException("Error requesting new token")
        }

    }
}
