package com.example.u2proyectonavegacion

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.u2proyectonavegacion.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        //setContentView(view) view = binding.root
        //return inflater.inflate(R.layout.fragment_home, container, false)
        //binding = FragmentHomeBinding.inflate(layoutInflater)


        //
        var navController = findNavController()

        binding.buttonHometoInside.setOnClickListener{
            Toast.makeText(context, "jala",Toast.LENGTH_LONG).show()
            //navController.navigate((R.id.action_homeFragment_to_insideHomeFragment))
            val nombre = binding.name.toString()
            Log.i("bas",nombre)
            val appaterno = binding.appat.toString()
            val apmaterno = binding.apmat.toString()
            val usuario = binding.user.toString()
            val correo = binding.correo.toString()
            val directions = HomeFragmentDirections.actionHomeFragmentToInsideHomeFragment("$nombre","$appaterno",apmaterno,usuario,correo)
            navController.navigate(directions)
        }

        return binding.root
    }

}