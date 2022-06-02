package com.example.u2proyectonavegacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.u2proyectonavegacion.databinding.FragmentInsideHomeBinding

class InsideHomeFragment : Fragment() {

    private lateinit var binding: FragmentInsideHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInsideHomeBinding.inflate(layoutInflater)

        val nombre = arguments?.getString("nombre")
        val pat = arguments?.getString("appaterno")
        val mat = arguments?.getString("apmaterno")
        val user  = arguments?.getString("usuario")
        val correo = arguments?.getString("correo")

        binding.name.setText(nombre)
        binding.paterno.setText(pat)
        binding.materno.setText(mat)
        binding.usuario.setText(user)
        binding.correo.setText(correo)

        //return inflater.inflate(R.layout.fragment_inside_home, container, false)
        return binding.root
    }

}