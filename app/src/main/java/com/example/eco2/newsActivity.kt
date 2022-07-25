package com.example.eco2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class newsActivity : AppCompatActivity() {

    lateinit var homeBtn: ImageButton
    lateinit var todoBtn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        homeBtn = findViewById(R.id.homeButton)
        todoBtn = findViewById(R.id.todoButton)

        homeBtn.setOnClickListener{
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        todoBtn.setOnClickListener{
            var intent = Intent(this, todoActivity::class.java)
            startActivity(intent)
        }
    }
}