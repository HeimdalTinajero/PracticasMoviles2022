package com.example.proyectofinal2022

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.proyectofinal2022.database.DATABASE_NAME
import com.example.proyectofinal2022.database.TABLE_USERS

import com.example.proyectofinal2022.databinding.ItemStoreBinding
import com.squareup.picasso.Picasso
import org.json.JSONArray
import org.json.JSONObject

class RandomHomeFragmentAdapter(private val imgs: JSONArray): RecyclerView.Adapter<RandomHomeFragmentAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomHomeFragmentAdapter.MainHolder {
        val binding = ItemStoreBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: RandomHomeFragmentAdapter.MainHolder, position: Int) {
        holder.render(imgs[position] as JSONObject)
    }

    override fun getItemCount(): Int = 5

    class MainHolder(val binding: ItemStoreBinding): RecyclerView.ViewHolder(binding.root){
        fun render(img: JSONObject){
            binding.tvitemtittle.setText(img.getString("title"))
            Picasso.get().load(img.getString("image")).into(binding.ivImageItem)
            binding.button.setOnClickListener{
            }
        }
    }
}