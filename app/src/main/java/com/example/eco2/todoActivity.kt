package com.example.eco2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class todoActivity : AppCompatActivity() {

    lateinit var homeBtn: ImageButton
    lateinit var newsBtn: ImageButton

    lateinit var listBtn: Button
    lateinit var dateText: TextView

    lateinit var simpleDateFormat: SimpleDateFormat
    lateinit var date: Date

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do)

        homeBtn = findViewById(R.id.homeButton)
        newsBtn = findViewById(R.id.newsButton)

        listBtn = findViewById(R.id.listButton)
        dateText = findViewById(R.id.dateText)

        val now: Long = System.currentTimeMillis()
        date = Date(now)
        simpleDateFormat = SimpleDateFormat("yyyy. MM. dd (E)") //형식 지정
        val getDate: String = simpleDateFormat.format(date)
        dateText.setText(getDate)

        //홈 화면 연결
        homeBtn.setOnClickListener{
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        //뉴스 화면 연결
        newsBtn.setOnClickListener{
            var intent = Intent(this, newsActivity::class.java)
            startActivity(intent)
        }


    }
}