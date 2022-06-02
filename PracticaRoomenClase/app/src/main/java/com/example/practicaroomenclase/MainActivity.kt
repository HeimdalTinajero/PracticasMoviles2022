package com.example.practicaroomenclase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.practicaroomenclase.database.User

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

/*        mainViewModel.saveUser(User(
            "userid02",
            "name02",
            1.72,
            72.2,
            "user02@user.com",
            "password12342"
            )
        )*/
        mainViewModel.getUser()
        //viewLifecycleOwner en lugar de this para fragment
        mainViewModel.savedUsers.observe(this, {usersList->
            if(!usersList.isNullOrEmpty()){
                for(user in usersList){
                    Log.d("thesearetheusers",user.user_name)
                }
            }else
                Log.d("thesearetheusers","null or empty")
        })

    }
}