package com.example.eco2

import android.content.Context
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
    lateinit var initialText: TextView

    lateinit var simpleDateFormat: SimpleDateFormat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do)

        homeBtn = findViewById(R.id.homeButton)
        newsBtn = findViewById(R.id.newsButton)

        listBtn = findViewById(R.id.listButton)
        dateText = findViewById(R.id.dateText)

        var calendar: Calendar = Calendar.getInstance()
        simpleDateFormat = SimpleDateFormat("yyyy. MM. dd(E)") //형식 지정
        var date: String = simpleDateFormat.format(calendar.getTime())
        dateText.setText(date)

        //목록 추가 버튼
        listBtn.setOnClickListener{
            var intent = Intent(this, listActivity::class.java)
            startActivity(intent)
        }

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