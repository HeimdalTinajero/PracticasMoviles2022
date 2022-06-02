package com.example.u2proyectonavegacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.u2proyectonavegacion.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_profile, container, false)
        binding = FragmentProfileBinding.inflate(layoutInflater)

        val nombre = arguments?.getString("nombre")
        val pat = arguments?.getString("appaterno")
        val mat = arguments?.getString("apmaterno")
        val user  = arguments?.getString("usuario")
        val correo = arguments?.getString("correo")

        return binding.root
    }

}