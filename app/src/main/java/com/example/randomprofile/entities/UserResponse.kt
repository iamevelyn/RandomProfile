package com.example.randomprofile.entities

import com.google.gson.annotations.SerializedName

data class UserResponse (
    @SerializedName("results") var users: List<User>,
    @SerializedName("info") var info: Info,
    ){

/*
    fun getusers():List<User>{
        return users
    }

    fun setusers(Users:List<User>){
        users = Users
    }

    fun getinfo():Info{
        return info
    }

    fun setinfo(Info:Info){
        info = Info
    }
*/

}


data class Info (
    @SerializedName("seed") var seed: String,
    @SerializedName("results") var results: Int,
    @SerializedName("page") var page: Int,
    @SerializedName("version") var version: String,
)