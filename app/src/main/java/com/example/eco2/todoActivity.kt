package com.example.eco2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.text.SimpleDateFormat
import java.util.*

class todoActivity : AppCompatActivity() {

    lateinit var homeBtn: ImageButton
    lateinit var newsBtn: ImageButton

    lateinit var dateText: TextView
    lateinit var initialText: TextView

    lateinit var simpleDateFormat: SimpleDateFormat

    lateinit var listSpinner: Spinner

    lateinit var listButton1: CheckBox
    lateinit var listButton2: CheckBox
    lateinit var listButton3: CheckBox
    lateinit var listButton4: CheckBox
    lateinit var listButton5: CheckBox
    lateinit var listButton6: CheckBox
    lateinit var listButton7: CheckBox

    lateinit var kgText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do)

        homeBtn = findViewById(R.id.homeButton)
        newsBtn = findViewById(R.id.newsButton)

        dateText = findViewById(R.id.dateText)

        kgText = findViewById(R.id.kgText)

        initialText = findViewById(R.id.initialText)

        listButton1 = findViewById(R.id.listButton1)
        listButton2 = findViewById(R.id.listButton2)
        listButton3 = findViewById(R.id.listButton3)
        listButton4 = findViewById(R.id.listButton4)
        listButton5 = findViewById(R.id.listButton5)
        listButton6 = findViewById(R.id.listButton6)
        listButton7 = findViewById(R.id.listButton7)

        //날짜
        var calendar: Calendar = Calendar.getInstance()
        simpleDateFormat = SimpleDateFormat("yyyy. MM. dd(E)") //형식 지정
        var date: String = simpleDateFormat.format(calendar.getTime())
        dateText.setText(date)

        //스피너에 들어갈 데이터
        val lists = resources.getStringArray(R.array.lists)

        listSpinner = findViewById(R.id.listSpinner)

        //어댑터 생성
        val adapter: ArrayAdapter<String> = ArrayAdapter(this, R.layout.spinner_item, lists)

        //어댑터 설정
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        //스피너에 어댑터 적용
        listSpinner.adapter = adapter

        //초기
        listButton1.visibility = View.GONE
        listButton2.visibility = View.GONE
        listButton3.visibility = View.GONE
        listButton4.visibility = View.GONE
        listButton5.visibility = View.GONE
        listButton6.visibility = View.GONE
        listButton7.visibility = View.GONE

        //스피너 이벤트
        listSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                listSpinner.setSelection(0) //시작 위치
                when(position){
                    1 -> {
                        initialText.visibility = View.INVISIBLE
                        listButton1.visibility = View.VISIBLE

                    }
                    2 -> {
                        initialText.visibility = View.INVISIBLE
                        listButton2.visibility = View.VISIBLE
                    }
                    3 -> {
                        initialText.visibility = View.INVISIBLE
                        listButton3.visibility = View.VISIBLE
                    }
                    4 -> {
                        initialText.visibility = View.INVISIBLE
                        listButton4.visibility = View.VISIBLE
                    }
                    5 -> {
                        initialText.visibility = View.INVISIBLE
                        listButton5.visibility = View.VISIBLE
                    }
                    6 -> {
                        initialText.visibility = View.INVISIBLE
                        listButton6.visibility = View.VISIBLE
                    }
                    7 -> {
                        initialText.visibility = View.INVISIBLE
                        listButton7.visibility = View.VISIBLE
                    }
                    else -> {

                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        var result: Float = 0.0f
        kgText.setText("${result}kg")

        class CheckboxListener: CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                when(buttonView?.id) {
                    R.id.listButton1 -> {
                        if (isChecked) {
                            result += 0.29f
                        }
                        else result -= 0.29f
                    }

                    R.id.listButton2 -> {
                        if (isChecked) result += 0.31f
                        else result -= 0.31f
                    }

                    R.id.listButton3 -> {
                        if (isChecked) result += 0.24f
                        else result -= 0.24f
                    }

                    R.id.listButton4 -> {
                        if (isChecked) result += 0.46f
                        else result -= 0.46f
                    }

                    R.id.listButton5 -> {
                        if (isChecked) result += 0.26f
                        else result -= 0.26f
                    }

                    R.id.listButton6 -> {
                        if (isChecked) result += 0.13f
                        else result -= 0.13f
                    }

                    R.id.listButton7 -> {
                        if (isChecked) result += 0.04f
                        else result -= 0.04f
                    }

                }
                kgText.setText("${String.format("%.2f", result)}kg")
            }

        }

        listButton1.setOnCheckedChangeListener(CheckboxListener())
        listButton2.setOnCheckedChangeListener(CheckboxListener())
        listButton3.setOnCheckedChangeListener(CheckboxListener())
        listButton4.setOnCheckedChangeListener(CheckboxListener())
        listButton5.setOnCheckedChangeListener(CheckboxListener())
        listButton6.setOnCheckedChangeListener(CheckboxListener())
        listButton7.setOnCheckedChangeListener(CheckboxListener())


        //홈 화면 연결
        homeBtn.setOnClickListener{
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        //뉴스 화면 연결
        newsBtn.setOnClickListener {
            var intent = Intent(this, newsActivity::class.java)
            startActivity(intent)
        }
    }
}