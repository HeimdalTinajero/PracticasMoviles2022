package com.example.practicafirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.practicafirebase.databinding.ActivityMainBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    val database = Firebase.database
    val myRef = database.reference
    var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

            myRef.child("usuarios").child(i.toString()).setValue(User("Juan$i", "12345"))


        binding.agregar.setOnClickListener(){
            guardar()
        }

        binding.buscarbt.setOnClickListener(){
        myRef.child("peliculas").get().addOnSuccessListener { response->
            binding.textomostrado.setText(response.toString())
        }.addOnFailureListener{
            Log.i ("frb","error")
        }


        }
    }

    fun guardar(){
        val name = binding.name.text.toString()
        val year = binding.year.text.toString()
        val imdb = binding.imdb.text.toString()
        val type = binding.type.text.toString()
        val poster= binding.poster.text.toString()
        val country = binding.country.text.toString()
        val genre= binding.genre.text.toString()

        myRef.child("peliculas").child(i.toString()).setValue(peliculas(name,year,imdb,type,poster,country,genre))
        i++
    }
}