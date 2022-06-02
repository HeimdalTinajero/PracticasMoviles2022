package com.example.practicagetsimple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.practicagetsimple.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var queue: RequestQueue
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        queue = Volley.newRequestQueue(this)
        binding.btnUpdatePokemon.setOnClickListener(){
            Log.i("JSONRESPONSE",binding.etPokemonAmount.text.toString())
            getPokemonlist(binding.etPokemonAmount.text.toString().toInt())
        }


    }

    fun getPokemonlist(listAmount: Int){

        val url = "https://pokeapi.co/api/v2/pokemon/?limit=${listAmount}"
        var itemlista: String

        val jsonRequest = JsonObjectRequest(url, { response ->
            Log.i("JSONRESPONSE",response.getJSONArray("results").toString())

            binding.rview.adapter = MainAdapter(response.getJSONArray("results"))
        },
            { error ->
                //TODO
                Log.i("JSONRESPONSE",error.message as String)
            })

        queue.add(jsonRequest)
    }
    override fun onStop() {
        super.onStop()
        queue.cancelAll("Stopped")
    }
}