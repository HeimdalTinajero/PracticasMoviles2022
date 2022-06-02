package com.example.u2proyectonavegacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.u2proyectonavegacion.databinding.FragmentInsideHomeBinding
import com.example.u2proyectonavegacion.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_settings, container, fa
        binding = FragmentSettingsBinding.inflate(layoutInflater)
        return binding.root
    }
}