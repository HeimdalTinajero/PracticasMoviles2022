package com.example.proyectofinal2022

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.proyectofinal2022.databinding.FragmentRandomHomeBinding
import com.example.proyectofinal2022.databinding.ItemStoreBinding

class RandomHomeFragment : Fragment() {
    private lateinit var binding: FragmentRandomHomeBinding
    private lateinit var binding2: ItemStoreBinding
    private lateinit var qeue: RequestQueue
    private lateinit var qeue2: RequestQueue
    private var x=0

    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentRandomHomeBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        qeue = Volley.newRequestQueue(context)
        val url = "https://fakestoreapi.com/products/"

        val jsonrequest = JsonArrayRequest(url, {response->
            binding.recyclerView.adapter = RandomHomeFragmentAdapter(response)
        },
            { error->
                Log.i("JSONRESPONSE1",error.toString())
            }
        )

        qeue.add(jsonrequest)

        binding = FragmentRandomHomeBinding.inflate(layoutInflater)
        return binding.root
    }

}
