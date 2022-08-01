package com.example.eco2

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar
import java.util.Date
import java.util.GregorianCalendar


class MainActivity : AppCompatActivity() {
    
    lateinit var todoBtn: ImageButton
    lateinit var newsBtn: ImageButton

    lateinit var add_to_do:TextView

    var countDownTimer: CountDownTimer? = null
    var tv_timer: TextView? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        todoBtn = findViewById(R.id.todoButton)
        newsBtn = findViewById(R.id.newsButton)

        tv_timer = findViewById(R.id.tv_timer)

        add_to_do = findViewById(R.id.add_to_do)
        
        todoBtn.setOnClickListener{
            var intent = Intent(this, todoActivity::class.java)
            startActivity(intent)
        }

        newsBtn.setOnClickListener{
            var intent = Intent(this, newsActivity::class.java)
            startActivity(intent)
        }

        countDownTimer = object : CountDownTimer(200000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val timer=tv_timer
                timer?.setText(getTime())
            }

            override fun onFinish() {}
        }
        val count=countDownTimer
        count?.start()

        var intent  = Intent(this,todoActivity::class.java)
        intent.putExtra("randomTodo","randomTodo")
        add_to_do.text ="개인컵 사용하기"
    }


    private fun getTime(): String? {
        val date = Date()
        val calendar: Calendar = GregorianCalendar()
        calendar.time = date
        val c_year = calendar[Calendar.YEAR]
        val c_month = calendar[Calendar.MONTH]
        val c_day = calendar[Calendar.DAY_OF_MONTH]
        val c_hour = calendar[Calendar.HOUR_OF_DAY]
        val c_min = calendar[Calendar.MINUTE]
        val c_sec = calendar[Calendar.SECOND]
        val baseCal: Calendar = GregorianCalendar(c_year, c_month, c_day, c_hour, c_min, c_sec)
        val targetCal: Calendar = GregorianCalendar(2029, 6, 24, 12, 36, 56) //비교대상날짜
        val diffSec = (targetCal.timeInMillis - baseCal.timeInMillis) / 1000
        val diffDays = diffSec / (24 * 60 * 60)
        targetCal.add(Calendar.DAY_OF_MONTH, (-diffDays).toInt())
        val dayTime = Math.floor((diffDays).toDouble()).toInt()
        val hourTime = Math.floor((diffSec / 3600-(dayTime*24)).toDouble()).toInt()
        val minTime = Math.floor(((diffSec - (3600 * 24 *dayTime)-(3600*hourTime)) / 60).toDouble()).toInt()
        val secTime = Math.floor(((diffSec - (3600 * 24 *dayTime)-(3600*hourTime)) % 60).toDouble()).toInt()
        val day = String.format("%02d", dayTime)
        val hour = String.format("%02d", hourTime)
        val min = String.format("%02d", minTime)
        val sec = String.format("%02d", secTime)
        return "1.5℃ 오르기까지\n" + day + "일 " + hour + "시간 " + min + "분 " + sec + "초 남았습니다."
    }

}