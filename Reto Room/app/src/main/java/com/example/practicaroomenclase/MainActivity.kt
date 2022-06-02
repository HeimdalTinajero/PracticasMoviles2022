package com.example.practicaroomenclase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.example.practicaroomenclase.database.User
import com.example.practicaroomenclase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    private var x=0
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.updateusers.setOnClickListener() {
            mainViewModel.saveUser(
                User(
                    "userid0" + x,
                    binding.usernames.text.toString()
                )
            )
            Log.d("deq", "Paso 1")
            x++
            Toast.makeText(this,"Añadido Satisfactoriamente.",Toast.LENGTH_LONG).show()
        }

        binding.showusers.setOnClickListener(){
            mainViewModel.getUser()
            //viewLifecycleOwner en lugar de this para fragment

            Log.d("deq","Paso2")

            mainViewModel.savedUsers.observe(this, {usersList->
                if(!usersList.isNullOrEmpty()){
                    for(user in usersList){
                        Log.d("deq",user.user_name)
                        binding.rview.adapter=MainAdapter(usersList)
                    }
                }else
                    Log.d("deq","null or empty")
            })
        }



    }
}