package com.subratgyawali.boilerplatemvp.data.pref

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.google.gson.Gson
import com.subratgyawali.boilerplatemvp.domain.model.UserResponseModel
import com.subratgyawali.boilerplatemvp.utils.Constants
import javax.inject.Inject

class SharedPreferenceManager @Inject constructor(val context: Context) {

    private val sharedPreferences =
        context.getSharedPreferences(Constants.PREF_FILE, Context.MODE_PRIVATE)

    var accessToken: String
        get() = sharedPreferences.getString(Constants.PREF_TOKEN, "")!!
        set(value) = sharedPreferences.edit { putString(Constants.PREF_TOKEN, value) }

    fun saveUser(user: UserResponseModel) {
        accessToken = "Bearer " + user.token
        val prefsEditor: SharedPreferences.Editor = sharedPreferences.edit();
        val gson = Gson()
        val json = gson.toJson(user)
        prefsEditor.putString("user", json)
        prefsEditor.apply()
    }

    fun getUser(): UserResponseModel? {
        val gson = Gson()
        val json = sharedPreferences.getString("user", "")
        val user = gson.fromJson<UserResponseModel>(json, UserResponseModel::class.java)
        return user
    }

    fun clearAll() {
        sharedPreferences.edit().clear().apply()
    }

}
