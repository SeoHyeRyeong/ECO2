package com.example.eco2

import android.content.ClipData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import org.jsoup.nodes.Document
import org.w3c.dom.Element

import java.util.*
import java.io.IOException

class newsActivity : AppCompatActivity() {

    lateinit var homeBtn: ImageButton
    lateinit var todoBtn: ImageButton
    lateinit var newsBtn:ImageButton

    lateinit var refreshBtn: ImageButton

    lateinit var recyclerView:RecyclerView

    var items : ArrayList<Item> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)


        homeBtn = findViewById(R.id.homeButton)
        todoBtn = findViewById(R.id.todoButton)
        refreshBtn = findViewById(R.id.refreshBtn)
        newsBtn = findViewById(R.id.newsButton)

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
                val url  = "https://news.naver.com/main/list.naver?mode=LS2D&mid=shm&sid1=102&sid2=252"
                val doc = Jsoup.connect(url).get()
                val today = doc.getElementsByAttributeValue("class","list_body newsflash_body")

                today.forEach { item ->
                    val item_link = /*base_url +*/item.select("a").attr("href")
                    val item_title = item.select("img").attr("alt")
                    val item_thumb = item.select("img").attr("src")
                    val item_summary = item.select(".lede").text()

                    //arrayList 리스트에 추가
                    items.add(Item(item_title, item_link, item_thumb, item_summary))
                }


                this@newsActivity.runOnUiThread(java.lang.Runnable {
                    //어답터 연결
                    recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
                    var adapter = MyAdapter(items, this)
                    recyclerView.adapter = adapter
                })
            }).start()
    }

    }



    //테이터 객체(제목/기사링크/썸네일이미지)
    data class Item(val title: String, val link: String, val thumb: String, val summary: String)

}