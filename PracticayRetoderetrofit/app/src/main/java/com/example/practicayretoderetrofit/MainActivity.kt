package com.example.practicayretoderetrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.practicayretoderetrofit.remote.PokemonEntry
import com.example.practicayretoderetrofit.remote.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = RetrofitBuilder.create().getPokemonById("27")
        //val responese = retrofit.getPokemonById("27")

        retrofit.enqueue(object: Callback<PokemonEntry>{
            override fun onResponse(call: Call<PokemonEntry>, response: Response<PokemonEntry>) {
                 //Log.d("rf","res: ${response.body()}")
                val stats = response.body()?.stats
                val types = response.body()?.type
                Log.d("rfit","name: ${response.body()?.name}")
                Log.d("rfit","sprite: ${response.body()?.sprites?.front_default}")
                //if(typesArray!=null){
                //Log.d("rfit","type:${reponse.body().types[0].type.name}")
                //}
                if(stats != null) {
                    for (stat in stats) {
                        Log.d("rfit", "stats:${stat.stat.stat_value} ${stat.base_stat}")
                    }
                }
                if(types != null){
                    for (type in types){
                        Log.d("rfit","type:${type.type.name}")
                    }
                }

            }

            override fun onFailure(call: Call<PokemonEntry>, t: Throwable) {
                Log.i("rf","error: ${t.message}")
            }
        })
    }
}