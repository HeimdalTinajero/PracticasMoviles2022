package com.example.primerpractica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.primerpractica.databinding.ActivityMainBinding
import android.media.MediaPlayer

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mediaPlayer: MediaPlayer

    var pv: Double = 0.0
    var op: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mediaPlayer = MediaPlayer.create(applicationContext,R.raw.sonidoboton)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val views = binding.root
        setContentView(views)
    //botones Calculadora
        binding.btnDEL.setOnClickListener{
            mediaPlayer.start()
            binding.resul.setText(binding.resul.text.dropLast(1))
        }

        binding.btnAC.setOnClickListener{
            mediaPlayer.start()
            binding.resul.text.clear()
            binding.opactual.setText("")
            binding.resans.setText("")
            pv=0.0
            op=""
        }

        binding.btnigual.setOnClickListener{
            mediaPlayer.start()
            if(binding.resul.text.isBlank()) binding.resul.setText("0")
            when(op){
                "*"-> {
                    binding.resans.setText(binding.resul.text.toString())
                    binding.resul.setText("${pv * binding.resul.text.toString().toDouble()}")
                    binding.opactual.setText("Anterior")
                    pv = binding.resul.text.toString().toDouble()
                }
                "+"->{
                    binding.resans.setText(binding.resul.text.toString())
                    binding.resul.setText("${pv + binding.resul.text.toString().toDouble()}")
                    binding.opactual.setText("Anterior")
                    pv = binding.resul.text.toString().toDouble()
                }
                "-"->{
                    binding.resans.setText(binding.resul.text.toString())
                    binding.resul.setText("${pv - binding.resul.text.toString().toDouble()}")
                    binding.opactual.setText("Anterior")
                    pv = binding.resul.text.toString().toDouble()
                }
                "/"->{
                    binding.resans.setText(binding.resul.text.toString())
                    binding.resul.setText("${pv / binding.resul.text.toString().toDouble()}")
                    binding.opactual.setText("Anterior")
                    pv = binding.resul.text.toString().toDouble()
                }
                else->{""}
            }
            op="$"
        }

        binding.btnporc.setOnClickListener{
            mediaPlayer.start()
            if(binding.resul.text.isBlank()) binding.resul.setText("0")
            binding.resans.setText("${binding.resul.text.toString().toDouble() / 100}")
            binding.opactual.setText("Porcentaje")
            pv=binding.resans.text.toString().toDouble()
            binding.resul.text.clear()
        }
    }

    fun botnum(view: View){
        if(op=="$") {
            binding.resans.setText(pv.toString())
            op=""
            binding.resul.text.clear()
        }
        mediaPlayer.start()
        val button = view as Button
        when(button.id){
            binding.btndot.id -> {
                if(!binding.resul.text.contains('.'))
                    binding.resul.text.append(".")
            }
            binding.btn1.id -> {binding.resul.text.append("1")}
            binding.btn2.id -> {binding.resul.text.append("2")}
            binding.btn3.id -> {binding.resul.text.append("3")}
            binding.btn4.id -> {binding.resul.text.append('4')}
            binding.btn5.id -> {binding.resul.text.append('5')}
            binding.btn6.id -> {binding.resul.text.append('6')}
            binding.btn7.id -> {binding.resul.text.append('7')}
            binding.btn8.id -> {binding.resul.text.append('8')}
            binding.btn9.id -> {binding.resul.text.append('9')}
            binding.btn0.id -> {binding.resul.text.append('0')}
            else->{}
        }
    }

    fun botop(view: View){
        mediaPlayer.start()
        val button = view as Button
        op = when(button.id){
            binding.btndiv.id -> {"/"}
            binding.btnmult.id -> {"*"}
            binding.btnrest.id -> {"-"}
            binding.btnsum.id -> {"+"}
            else->{""}
        }
        when(op) {
            "/" -> {
                binding.opactual.setText("Dividiendo")
            }
            "+" -> {
                binding.opactual.setText("Sumando")
            }
            "*" -> {
                binding.opactual.setText("Multiplicando")
            }
            "-" -> {
                binding.opactual.setText("Restando")
            }
            else -> {
                ""
            }
        }
        if(binding.resul.text.isBlank()){
            binding.resans.setText(pv.toString())
        }else{
            pv = binding.resul.text.toString().toDouble()
            binding.resans.setText(pv.toString())
            binding.resul.text.clear()
        }
    }
}
