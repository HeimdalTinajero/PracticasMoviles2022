package com.example.practicagetsimple

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.JsonObjectRequest
import com.example.practicagetsimple.databinding.ItemPokemonBinding
import org.json.JSONArray
import org.json.JSONObject

class MainAdapter(private val videos: JSONArray): RecyclerView.Adapter<MainAdapter.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainHolder {
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainAdapter.MainHolder, position: Int) {
        holder.render(videos[position] as JSONObject)
    }

    override fun getItemCount(): Int = videos.length()

    class MainHolder(val binding: ItemPokemonBinding):RecyclerView.ViewHolder(binding.root){
        fun render(video: JSONObject){
            binding.pokimons.setText(video.getString("name"))
        }
    }
}