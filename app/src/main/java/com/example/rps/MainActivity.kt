package com.example.rps

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.rps.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var input: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        binding.rockButton.setOnClickListener {
            input = "rock"
            binding.resultValueText.text = rps(input)
            binding.youImage.setImageResource(R.drawable.rock)
        }
        binding.paperButton.setOnClickListener {
            input = "paper"
            binding.resultValueText.text = rps(input)
            binding.youImage.setImageResource(R.drawable.paper)
        }
        binding.scissorsButton.setOnClickListener {
            input = "scissors"
            binding.resultValueText.text = rps(input)
            binding.youImage.setImageResource(R.drawable.scissors)
        }
    }

    private fun rps(userInput: String) : String{
        val image: ImageView = findViewById(R.id.computer_image)
        var result = ""
        val computerInput = when (Random.nextInt(3)) {
            1 -> "rock"
            2 -> "paper"
            else -> "scissors"
        }

        if(computerInput == "rock") {
            if(userInput == "paper") {
                result = "YOU WIN"
            }
            else if (userInput == "scissors") {
                result = "YOU LOSE"
            }
            else {
                result = "DRAW"
            }
            image.setImageResource(R.drawable.rock)
        }
        else if(computerInput == "paper") {
            if(userInput == "scissors") {
                result = "YOU WIN"
            }
            else if (userInput == "rock") {
                result = "YOU LOSE"
            }
            else {
                result = "DRAW"
            }
            image.setImageResource(R.drawable.paper)
        }
        else if(computerInput == "scissors"){
            if(userInput == "rock") {
                result = "YOU WIN"
            }
            else if (userInput == "paper"){
                result = "YOU LOSE"
            }
            else {
                result = "DRAW"
            }
            image.setImageResource(R.drawable.scissors)
        }
        return result
    }
}