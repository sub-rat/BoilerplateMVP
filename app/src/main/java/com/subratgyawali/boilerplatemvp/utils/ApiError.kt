package com.subratgyawali.boilerplatemvp.utils


import com.google.gson.JsonParser
import retrofit2.HttpException

class ApiError constructor(error: Throwable) {
    var message = "An error occurred"

    init {
        if (error is HttpException && error.code() != 200) {
            val errorJsonString = error.response()?.errorBody()?.string()
            this.message = JsonParser.parseString(errorJsonString)
                                       .asJsonObject["message"]
                                       .asString
        } else {
            this.message = error.message ?: this.message
        }
    }
}