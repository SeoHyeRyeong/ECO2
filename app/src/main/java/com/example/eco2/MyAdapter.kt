package com.example.eco2

import java.util.ArrayList
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapter(val items: ArrayList<newsActivity.Item>, context: Context) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    //뷰홀더
    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

         var tv_title: TextView = view.findViewById(R.id.tv_title)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ViewHolder(v)
    }

    //아이템 개수 변환
    override fun getItemCount(): Int {
        return items.size
    }

    //position번째 데이터와 xml 연결
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_title?.text = items.get(position).title
        val into = Glide.with(holder.view.context)
            .load(items.get(position).thumb)
            .fitCenter()
            .into(holder.view.findViewById(R.id.imageView))

        //Click Event
        holder.itemView.setOnClickListener {
            val openUrl = Intent(Intent.ACTION_VIEW)
            openUrl.data = Uri.parse(items.get(position).link)
            startActivity(holder.view.context, openUrl, null)
        }
    }

}