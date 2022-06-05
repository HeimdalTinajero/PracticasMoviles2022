package com.example.u2proyectonavegacion

import android.os.Bundle
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
        //binding = FragmentHomeBinding.inflate(inflater, container, false)
        //setContentView(view) view = binding.root
        //return inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.inflate(layoutInflater)


        //
        var navController = findNavController()

        binding.buttonHometoInside.setOnClickListener{
            Toast.makeText(context, "jala",Toast.LENGTH_LONG).show()
            //navController.navigate((R.id.action_homeFragment_to_insideHomeFragment))
            val textArgument = "desde home"
            val directions = HomeFragmentDirections.actionHomeFragmentToInsideHomeFragment(textArgument)
            navController.navigate(directions)
        }

        return binding.root
    }

}