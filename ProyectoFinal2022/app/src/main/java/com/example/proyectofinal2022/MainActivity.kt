package com.example.proyectofinal2022

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.proyectofinal2022.databinding.ActivityMainBinding
import androidx.activity.viewModels
import com.example.proyectofinal2022.database.User
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var user=binding.nombreusuario.text
        Log.d("asda", user.toString())



        binding.login.setOnClickListener() {
            startActivity(Intent(this,apphome::class.java).putExtra("name",user?.toString()))
        }
    }
}


//FIREBASE Guardado de Usuarios
//        myRef.child("users").child("1").setValue(User("Juan","23 de Marzo de 2010","0","0","1234"))
//      myRef.child("users").child("2").setValue(User("Pedro","25 de Mayo de 2012","0","0","1234"))
//    myRef.child("users").child("3").setValue(User("Luis","3 de Junio de 2013","0","0","1234"))

/*      binding.buscarbt.setOnClickListener(){
          myRef.child("peliculas").get().addOnSuccessListener { response->
              binding.textomostrado.setText(response.toString())
          }.addOnFailureListener{
              Log.i ("frb","error")
          }


      }*/

/*
class MainActivity2(username:String): AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    val database = Firebase.database
    val myRef = database.reference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

//FIREBASE Guardado de Usuarios
//        myRef.child("users").child("1").setValue(User("Juan","23 de Marzo de 2010","0","0","1234"))
        //      myRef.child("users").child("2").setValue(User("Pedro","25 de Mayo de 2012","0","0","1234"))
        //    myRef.child("users").child("3").setValue(User("Luis","3 de Junio de 2013","0","0","1234"))

        /*      binding.buscarbt.setOnClickListener(){
                  myRef.child("peliculas").get().addOnSuccessListener { response->
                      binding.textomostrado.setText(response.toString())
                  }.addOnFailureListener{
                      Log.i ("frb","error")
                  }


              }*/

        //NAV
        val navView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        var navController = navHostFragment.navController
        navView.setupWithNavController(navController)
    }
}*/