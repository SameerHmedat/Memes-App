package com.example.memesapp.service

import com.example.memesapp.response.JokeResponse
import retrofit2.Call
import retrofit2.http.GET

interface JokeApi {

    @GET("get_memes")
    fun getJokes(): Call<JokeResponse>

}