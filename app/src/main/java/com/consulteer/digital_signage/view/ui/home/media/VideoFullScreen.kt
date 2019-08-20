package com.consulteer.digital_signage.view.ui.home.media

import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.consulteer.digital_signage.R

class VideoFullScreen : AppCompatActivity() {
    lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_full_screen)
        webView = findViewById(R.id.full_video)

        val link = intent.getStringExtra("link")
        webView.loadUrl(link)
    }
}
