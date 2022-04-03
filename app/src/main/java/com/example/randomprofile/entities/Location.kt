package com.example.randomprofile.entities

import com.google.gson.annotations.SerializedName

data class Location (
    @SerializedName("street") var street: Street,
    @SerializedName("city") var city: String,
    @SerializedName("state") var state: String,
    @SerializedName("country") var country: String,
    @SerializedName("postcode") var postcode: String,
    @SerializedName("coordinates") var coordinates: Coordinates,
    @SerializedName("timezone") var timezone: Timezone
)

data class Street (
    @SerializedName("number") var number: String,
    @SerializedName("name") var name: String,
)

data class Coordinates (
    @SerializedName("title") var title: String,
    @SerializedName("first") var first: String,
    @SerializedName("last") var last: String,
)

data class Timezone (
    @SerializedName("offset") var offset: String,
    @SerializedName("description") var description: String
)