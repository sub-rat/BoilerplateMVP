package com.subratgyawali.boilerplatemvp.utils

import com.subratgyawali.boilerplatemvp.BuildConfig


object Environment {

    fun getServerUrl(): String {
     return BuildConfig.SERVER_URL
    }
}