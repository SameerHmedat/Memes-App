package com.example.memesapp.service

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object JokeApiService {

    private const val BASE_URL="https://api.imgflip.com/"
    private var jokeApi:JokeApi ?=null

    fun getInstance():JokeApi{

        if (jokeApi==null){

            val retrofit=Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            jokeApi=retrofit.create(JokeApi::class.java)
        }

        return jokeApi!!

    }
}