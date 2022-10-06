package com.example.memesapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.memesapp.model.Data
import com.example.memesapp.response.JokeResponse
import com.example.memesapp.service.JokeApiService
import retrofit2.Call
import retrofit2.Response

class MainViewModel:ViewModel() {

    val dataMutableLiveData=MutableLiveData<Data>()

    init {
        getJokesViewModel()
    }

     fun getJokesViewModel() {
        JokeApiService.getInstance().getJokes().enqueue(object:retrofit2.Callback<JokeResponse>{
            override fun onResponse(call: Call<JokeResponse>, response: Response<JokeResponse>) {
               dataMutableLiveData.value=response.body()!!.data
            }

            override fun onFailure(call: Call<JokeResponse>, t: Throwable){
                Log.d("TAG", "onFailure: " + t.message)
            }

        })
    }

}