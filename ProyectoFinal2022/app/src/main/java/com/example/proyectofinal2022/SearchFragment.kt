package com.example.proyectofinal2022

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.room.RoomSQLiteQuery
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.proyectofinal2022.database.TABLE_USERS
import com.example.proyectofinal2022.database.User
import com.example.proyectofinal2022.databinding.FragmentSearchBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.squareup.picasso.Picasso

class SearchFragment : Fragment() {
    val datauser = Firebase.database
    val myRef=datauser.reference
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: FragmentSearchBinding
    private lateinit var qeue1: RequestQueue
    var imurl=""
    lateinit var user_on: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(layoutInflater)

       qeue1 = Volley.newRequestQueue(context)
        binding.search.setOnClickListener(){
            getItem(binding.editText.text.toString())
            binding.editText.text.clear()
        }

        binding.agregar.setOnClickListener()
        {
            mainViewModel.saveUser(
                User(
                    binding.title.text.toString(),
                    imurl
                )
            )
            myRef.child("users").child("Juan").child("wishlist").get().addOnSuccessListener { response->
                var wishlist = response.value.toString().toInt()
                myRef.child("users").child("Juan").child("wishlist").setValue(wishlist+1)

            }.addOnFailureListener{
                Log.i ("frb","error")
            }
            myRef.child("users").child("Juan").child("wishlist").get().addOnSuccessListener { response->
                var level = response.value.toString().toInt()
                myRef.child("users").child("Juan").child("level").setValue(level/3)

            }.addOnFailureListener{
                Log.i ("frb","error")
            }

        }
        return binding.root
        // Inflate the layout for this fragment
    }

    fun getItem(item: String){
        val url = "https://fakestoreapi.com/products/${item}"
        val jsonRequest = JsonObjectRequest(url,{
            respone->
            Log.i("JSONRESPONSE","asdfas")
            binding.title.setText(respone.getString("title"))
            binding.price.setText("$"+respone.getString("price"))
            imurl=respone.getString(("image"))
            Picasso.get().load(respone.getString("image")).into(binding.imageView)

        }, {error->
            Log.i("JSONRESPONSE","Error Desconoido")
        })
        qeue1.add(jsonRequest)
    }

}