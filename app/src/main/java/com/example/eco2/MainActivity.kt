package com.example.eco2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    
    lateinit var todoBtn: ImageButton
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        todoBtn = findViewById(R.id.todoButton)
        
        todoBtn.setOnClickListener{
            var intent = Intent(this, toDo::class.java)
            startActivity(intent)
        }
    }
    

}