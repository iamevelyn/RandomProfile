package com.example.randomprofile.entities

import com.google.gson.annotations.SerializedName



data class User (
    @SerializedName("gender") var gender: String,
    @SerializedName("name") var name: Name,
    @SerializedName("location") var location: Location,
    @SerializedName("email") var email: String,
    @SerializedName("login") var security: Security,
    @SerializedName("dob") var dob: Dob,
    @SerializedName("phone") var phone: String,
    @SerializedName("cell") var cell: String,
    @SerializedName("registered") var registered: Registered,
    @SerializedName("id") var id: Id,
    @SerializedName("picture") var picture: Picture,
    @SerializedName("nat") var nat: String,


    ){
/*
    fun getgender():String{
        return gender
    }

    fun setgender(Gender:String){
        gender = Gender
    }

    fun getname():Name{
        return name
    }

    fun setname(Name:Name){
        name = Name
    }

    fun getlocation():Location{
        return location
    }

    fun setlocation(Location:Location){
        location = Location
    }*/

}

data class Name (
    @SerializedName("title") var title: String,
    @SerializedName("first") var first: String,
    @SerializedName("last") var last: String,
){

}

data class Dob (
    @SerializedName("date") var date: String,
    @SerializedName("age") var age: String
){

}

data class Picture (
    @SerializedName("large") var large: String,
    @SerializedName("medium") var medium: String,
    @SerializedName("thumbnail") var thumbnail: String,
){

}

