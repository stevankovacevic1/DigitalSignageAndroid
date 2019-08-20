package com.consulteer.digital_signage.view.ui.home.media

import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.consulteer.digital_signage.R

class YoutubeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    internal var webView: WebView
    internal var button: Button

    init {
        webView = itemView.findViewById(R.id.video_view)
        button = itemView.findViewById(R.id.fullscreen)
        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()
        webView.settings.javaScriptEnabled = true
    }
}
