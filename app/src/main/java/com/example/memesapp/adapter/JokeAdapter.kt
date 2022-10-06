package com.example.memesapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.memesapp.R
import com.example.memesapp.model.Meme
import kotlinx.android.synthetic.main.item_view.view.*

class JokeAdapter( val JokesList : List<Meme>):
    RecyclerView.Adapter<JokeAdapter.JokeViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_view, parent, false
        )

        return JokeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        val currentItem: Meme = JokesList[position]
        holder.bind(currentItem)

    }

    override fun getItemCount(): Int {
        return JokesList.size
    }

    class JokeViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(meme: Meme){
            itemView.txt_name.text=meme.name
            Glide.with(itemView).load(meme.url).into(itemView.img_meme)
        }
    }
}