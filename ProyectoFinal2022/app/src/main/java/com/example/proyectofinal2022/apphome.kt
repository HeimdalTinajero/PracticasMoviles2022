package com.example.proyectofinal2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.proyectofinal2022.databinding.ActivityApphomeBinding
import com.example.proyectofinal2022.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class apphome : AppCompatActivity() {


    val database= Firebase.database
    val myRef=database.reference
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityApphomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApphomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val ObjetoIntent: Intent =intent
        var name = ObjetoIntent.getStringExtra("name")

        binding.Saludo.setText("Bienvenido ${name}")

        if (name != null) {
            myRef.child("users").child(name).child("date").get().addOnSuccessListener { response->
                var date = response.value.toString()
                binding.userdate.setText("Desde "+date)
            }.addOnFailureListener{
                Log.i ("frb","error")
            }
        }
        if (name != null) {
            myRef.child("users").child(name).child("level").get().addOnSuccessListener { response->
                binding.userlevel.setText("Lv."+response.value.toString())
            }.addOnFailureListener{
                Log.i ("frb","error")
            }
        }
        if (name != null) {
            myRef.child("users").child(name).child("wishlist").get().addOnSuccessListener { response->
                binding.userwishproducts.setText("Bolsa "+response.value.toString())
            }.addOnFailureListener{
                Log.i ("frb","error")
            }
        }

        val navView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        var navController = navHostFragment.navController
        navView.setupWithNavController(navController)


    }
}