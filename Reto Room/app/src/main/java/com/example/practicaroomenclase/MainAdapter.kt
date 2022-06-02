package com.example.practicaroomenclase

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practicaroomenclase.database.User
import com.example.practicaroomenclase.database.UserEntity
import com.example.practicaroomenclase.databinding.ItemUsuarioBinding


class MainAdapter(private val videos: List<User>): RecyclerView.Adapter<MainAdapter.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainHolder {
        val binding = ItemUsuarioBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainAdapter.MainHolder, position: Int) {
        holder.render(videos[position])
    }

    override fun getItemCount(): Int = videos.size


    class MainHolder(val binding: ItemUsuarioBinding):RecyclerView.ViewHolder(binding.root){
        fun render(video: User){
            binding.pokimons.setText(video.user_name)
        }
    }
}