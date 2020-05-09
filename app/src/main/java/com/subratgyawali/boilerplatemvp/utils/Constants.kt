package com.subratgyawali.boilerplatemvp.utils

object Constants {
    /**
     * SharedPreference keystore
     */
    const val PREF_FILE = "delivery"
    const val PREF_TOKEN = "access_token"
    const val PREF_REFRESH_TOKEN = "refresh_token"
    const val PREF_PHONE = "phone"
    const val PREF_ID = "id"
    const val PREF_DISTRIBUTOR_ID = "distributor_id"
    const val PREF_APP_STATE = "app_state"
    const val PREF_END_POINT = "end_point"
    const val PREF_ORGANIZATION_ID = "organization_id"

    /**
     * connection timeout
     */
    const val READ_TIME_OUT: Long = 180
    const val CONNECT_TIME_OUT: Long = 180
    const val TOKEN_EXPIRED = 401
}