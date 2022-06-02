package com.example.a2marzo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val constate: String = "yesyesy cadena"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val a: Int = 5
        a= 4
        */

        var b: Int = 4
        b = 3
        ejecutar(1)
        ejecutar1()
        impr()
        unfor()
        unwhile()
        Log.i("Basics", "Valor de la b $b")
        Toast.makeText(this, "menasj",Toast.LENGTH_LONG)
    }

    fun ejecutar(a: Int):Boolean{
        var array = arrayOf(1,2,3,4,5)
        if(a in array) //&& || != < > ==
                return true
        else
            return false
    }
    fun ejecutar1(){
        val x= 1
        when (x){
            1 -> Log.i("Basics","Es un uno")
            2 -> {
                var algo = "lores"
                var otro = "ipsum"
                Log.i("Basics",algo+otro)
            }
            else -> Log.i("Basics","no pos no")
        }
    }
    fun impr(){
        Log.i("Bascis", "Cadena $constate")
    }
    fun unfor(){
        var array = arrayOf(1,2,3,4,5)
        for (numero in array){
            Log.i("Basics",numero.toString())
        }
    }
    fun unwhile(){
        var x = 0
        while(x<5){
            Log.i("Bascics",x.toString())
            x++
        }
        x=0
        do{
           Log.i("Basics",x.toString())
           x++
        }while(x<5)
    }
}