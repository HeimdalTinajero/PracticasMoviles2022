package com.example.practicafirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = Firebase.database
        val myRef = database.reference
        var i=10

        while(i>0) {
            myRef.child("usuarios").child(i.toString()).setValue(User("Juan$i", "12345"))
            i--
        }

        while(!(i==10)){
            myRef.child("usuarios").child(i.toString()).get().addOnSuccessListener { response ->
                Log.d("fbr",response.value.toString())
            }.addOnFailureListener{
                Log.d("fbr","Error geting data",it)
            }
            i++
        }

    }
}