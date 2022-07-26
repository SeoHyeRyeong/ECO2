package com.example.eco2

import android.content.ClipData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.jsoup.Jsoup
import java.util.*
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.io.IOException

class newsActivity : AppCompatActivity() {

    lateinit var homeBtn: ImageButton
    lateinit var todoBtn: ImageButton
    lateinit var refreshBtn: ImageButton

    lateinit var recyclerView:RecyclerView

    var items : ArrayList<Item> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)


        homeBtn = findViewById(R.id.homeButton)
        todoBtn = findViewById(R.id.todoButton)
        refreshBtn = findViewById(R.id.refreshBtn)

        recyclerView = findViewById(R.id.recyclerView)

        homeBtn.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        todoBtn.setOnClickListener {
            var intent = Intent(this, todoActivity::class.java)
            startActivity(intent)
        }


        refreshBtn.setOnClickListener {
            Thread(Runnable {
                val url = "https://sports.news.naver.com/index.nhn"
                val base_url = "https://sports.news.naver.com/"
                val doc = Jsoup.connect(url).get()
                val title = doc.title()
                //val links = doc.select("a[href]")
                //필요한 자료만 - 오늘의 스포츠 NoW 목록을 가져오자. HTML  태그등을 분석해서 무엇을 가져 올지 결정해야 한다.
                val today = doc.select("ul.today_list li.today_item")

                today.forEach { item ->
                    val item_link = base_url + item.select("a").attr("href")
                    val item_title = item.select("strong.title").text()
                    val item_thumb = item.select("img").attr("src")
                    val item_summary = item.select("p.news").text()

                    //arrayList 리스트에 추가해 준다.
                    items.add(Item(item_title, item_link, item_thumb, item_summary))
                }


                this@newsActivity.runOnUiThread(java.lang.Runnable {
                    //어답터 연결하기
                    recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
                    var adapter = MyAdapter(items, this)
                    recyclerView.adapter = adapter
                })
            }).start()
    }
    }
    //테이터 객체(제목/기사링크/썸네일이미지)
    data class Item(val title: String, val link: String, val thumb: String, val summary: String)

    val clientId = "zVorJaB67x3RJ1fWnllZ"
    val clientSecret = "7jJ1jkb5pA"
}