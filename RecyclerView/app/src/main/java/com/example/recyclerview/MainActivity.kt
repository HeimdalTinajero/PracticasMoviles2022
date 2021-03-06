package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerview.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fakeVideoData: Array<JSONObject> = arrayOf(
            JSONObject("{\"title\": \"Marucio Mauro\"}"),
            JSONObject("{\"title\": \"Marucio Mauro\"}"),
            JSONObject("{\"title\": \"Marucio Mauro\"}"),
            JSONObject("{\"title\": \"Marucio Mauro\"}"),
            JSONObject("{\"title\": \"Marucio Mauro\"}"),
            JSONObject("{\"title\": \"Marucio Mauro\"}"),
            JSONObject("{\"title\": \"Marucio Mauro\"}"),
            JSONObject("{\"title\": \"Marucio Mauro\"}"),
            JSONObject("{\"title\": \"Marucio Mauro\"}"),
            JSONObject("{\"title\": \"Marucio Mauro\"}"),
            JSONObject("{\"title\": \"Marucio Mauro\"}"),
            JSONObject("{\"title\": \"Marucio Mauro\"}"),
        )

        binding.rvVideoEntries.adapter= MainAdapter(fakeVideoData)
    }
}