package com.example.memesapp.response


import com.example.memesapp.model.Data
import com.google.gson.annotations.SerializedName

data class JokeResponse(

    @SerializedName("data")
    val data: Data,
    @SerializedName("success")
    val success: Boolean
)