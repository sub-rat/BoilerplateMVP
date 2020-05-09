package com.subratgyawali.boilerplatemvp.domain.model

import com.google.gson.annotations.SerializedName


data class UserResponseModel(
    @SerializedName("email") var email: String,
    @SerializedName("id")var id: Int,
    @SerializedName("is_first_time_login")var is_first_time_login: Int,
    @SerializedName("name")var name: String,
    @SerializedName("photo") var photo: String,
    @SerializedName("role_id")var role_id: Int,
    @SerializedName("tenant")var tenant: Int,
    @SerializedName("token")var token: String,
    @SerializedName("websiteId")var websiteId: Int
)

data class UserRequestModel (
        @SerializedName("email") val email: String,
        @SerializedName("password") val password: String
)

data class UsersProfileModel(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("fullname") val fullname: String?= null,
    @SerializedName("username")val username: String?= null,
    @SerializedName("streetAddress")val streetAddress: String?= null,
    @SerializedName("postalCode")val postalCode: String?= null,
    @SerializedName("postalCity")val postalCity: String?= null,
    @SerializedName("countryId")val countryId: Int?= null,
    @SerializedName("country")val country: String? = null,
    @SerializedName("phone")val phone: String? = null,
    @SerializedName("email")val email: String? = null,
    @SerializedName("photo")val photo: PhotoModel? = null
)

data class PhotoModel (
    @SerializedName("id")val id: Int?= null,
    @SerializedName("filename") var filename: String?= null,
    @SerializedName("filetype") var filetype: String?= null,
    @SerializedName("value") var value: String?= null,
    @SerializedName("filepath")val filepath: String?= null,
    @SerializedName("thumb")val thumb: String?= null,
    @SerializedName("url")val url: String?= null
)
