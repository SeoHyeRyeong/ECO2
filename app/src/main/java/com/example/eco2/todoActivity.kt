package com.example.eco2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class todoActivity : AppCompatActivity() {

    lateinit var homeBtn: ImageButton
    lateinit var newsBtn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do)

        homeBtn = findViewById(R.id.homeButton)
        newsBtn = findViewById(R.id.newsButton)

        homeBtn.setOnClickListener{
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        newsBtn.setOnClickListener{
            var intent = Intent(this, newsActivity::class.java)
            startActivity(intent)
        }
    }
}