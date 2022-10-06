package com.example.memesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.memesapp.adapter.JokeAdapter
import com.example.memesapp.model.Data
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by lazy { ViewModelProvider(this)[MainViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupInfoUIList()

    }

    private fun setupInfoUIList() {

        viewModel.dataMutableLiveData.observe(this@MainActivity) { data ->
            setInfoList(data)
        }
    }

    private fun setInfoList(body: Data) {
        val jokeAdapter = JokeAdapter(body.memes)
        Log.d("JokeActivity",jokeAdapter.JokesList.size.toString())
        rcJokes.layoutManager = LinearLayoutManager(this)
        rcJokes.adapter = jokeAdapter

    }
}