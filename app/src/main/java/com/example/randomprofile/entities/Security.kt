package com.example.randomprofile.entities

import com.google.gson.annotations.SerializedName

data class Security (
    @SerializedName("uuid") var uuid: String,
    @SerializedName("username") var username: String,
    @SerializedName("password") var password: String,
    @SerializedName("salt") var salt: String,
    @SerializedName("md5") var md5: String,
    @SerializedName("sha1") var sha1: String,
    @SerializedName("sha256") var sha256: String
)

data class Registered (
    @SerializedName("date") var date: String,
    @SerializedName("age") var age: String
)

data class Id (
    @SerializedName("name") var name: String,
    @SerializedName("value") var value: String
)