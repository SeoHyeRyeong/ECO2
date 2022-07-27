package com.example.eco2

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class listActivity : AppCompatActivity() {

    lateinit var listBtn1: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        listBtn1 = findViewById(R.id.listButton1)

        listBtn1.setClickable(true)
        listBtn1.setOnClickListener {
            var str_list1: String = listBtn1.text.toString()

            val intent = Intent(this, todoActivity::class.java)
            intent.putExtra("str_list1", str_list1)
            startActivity(intent)
        }

    }

}