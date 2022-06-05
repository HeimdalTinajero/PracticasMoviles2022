package com.example.proyectofinal2022

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.proyectofinal2022.databinding.FragmentProfileBinding
import com.example.proyectofinal2022.databinding.FragmentRandomHomeBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ProfileFragment : Fragment() {
   private lateinit var binding: FragmentProfileBinding

    val database= Firebase.database
    val myRef=database.reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentProfileBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//FIREBASE Guardado de Usuarios
   /*     myRef.child("users").child("Juan").setValue(User("23 de Marzo de 2010","0","0","1234"))
        myRef.child("users").child("Pedro").setValue(User("25 de Mayo de 2012","0","0","1234"))
        myRef.child("users").child("Luis").setValue(User("3 de Junio de 2013","0","0","1234"))
*/
        binding = FragmentProfileBinding.inflate(layoutInflater)


        return binding.root
    }

}