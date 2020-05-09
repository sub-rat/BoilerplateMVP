package com.subratgyawali.boilerplatemvp.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("message") @Expose var statusMessage: String? = null,
    @SerializedName("success") @Expose var status: Boolean,
    @SerializedName("data") @Expose var response: T? = null

)