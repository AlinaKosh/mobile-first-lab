package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity2Activity : AppCompatActivity() {
    private lateinit var nameResult: TextView
    private lateinit var ageResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity2)

        nameResult = findViewById(R.id.nameFromKod)
        ageResult = findViewById(R.id.ageFromKod)
        val gender = findViewById<TextView>(R.id.genderFromKod)

        val name = intent.getStringExtra("name")
        val age = intent.getStringExtra("age")
        val receivedGender = intent.getStringExtra("gender")

        nameResult.text = name
        ageResult.text = age
        gender.text = receivedGender

        val backgroundButton = findViewById<Button>(R.id.background)
        backgroundButton.setOnClickListener {
            val randomColor = Color.argb(255, Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
            findViewById<View>(android.R.id.content).setBackgroundColor(randomColor)
        }
        val nextButton = findViewById<Button>(R.id.next)
        nextButton.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
    }
}