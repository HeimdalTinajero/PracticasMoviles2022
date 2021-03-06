package com.example.proyectofinal2022

import android.util.Property
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.isInvisible
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import androidx.room.RoomDatabase

import com.example.proyectofinal2022.database.User
import com.example.proyectofinal2022.databinding.ItemStore2Binding
import com.squareup.picasso.Picasso

class WishlistFragmentAdapter(private val imgs: List<User>): RecyclerView.Adapter<WishlistFragmentAdapter.MainHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WishlistFragmentAdapter.MainHolder {
        val binding = ItemStore2Binding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: WishlistFragmentAdapter.MainHolder, position: Int) {
        holder.render(imgs[position])
    }

    override fun getItemCount(): Int =imgs.size

    class MainHolder(val binding: ItemStore2Binding):RecyclerView.ViewHolder(binding.root){
        fun render(img: User){
            binding.itemname.setText(img.user_id)
            Picasso.get().load(img.user_name).into(binding.ivImageItem)
            binding.borrar.setOnClickListener{
                    binding.itemname.isInvisible
            }
        }

    }
}