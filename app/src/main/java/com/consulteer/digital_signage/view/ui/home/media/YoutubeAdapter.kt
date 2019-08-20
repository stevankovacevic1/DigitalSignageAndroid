package com.consulteer.digital_signage.view.ui.home.media

import android.content.Context
import android.content.Intent
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.consulteer.digital_signage.R

import java.util.ArrayList

class YoutubeAdapter(internal var arrayList: ArrayList<DataSetList>, internal var context: Context) :
    RecyclerView.Adapter<YoutubeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YoutubeViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_media, parent, false)
        return YoutubeViewHolder(view)
    }

    override fun onBindViewHolder(holder: YoutubeViewHolder, positionOfIndex: Int) {
        val current = arrayList[positionOfIndex]
        holder.webView.loadUrl(current.link)
        holder.button.setOnClickListener {
            val i = Intent(context, VideoFullScreen::class.java)
            i.putExtra("link", current.link)
            context.startActivity(i)
        }

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}
