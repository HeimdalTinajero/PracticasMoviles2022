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

        val argumentoRecibido = arguments?.getString("argumentopasado")
        binding.textview2.setText(argumentoRecibido)
        //return inflater.inflate(R.layout.fragment_inside_home, container, false)
        return binding.root
    }

}