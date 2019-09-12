package com.consulteer.digital_signage

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class BottomNav : AppCompatActivity() {

    private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.fragmentinfo -> {
                textMessage.setText("Home")
                return@OnNavigationItemSelectedListener true
            }
            R.id.fragmentempolyees -> {
                textMessage.setText("Employees")
                return@OnNavigationItemSelectedListener true
            }
            R.id.fragmentleaverequest -> {
                textMessage.setText("Leave Request")
                return@OnNavigationItemSelectedListener true
            }
            R.id.fragmentmedia -> {
                textMessage.setText("Media")
                return@OnNavigationItemSelectedListener true
            }
            R.id.fragmentprofile -> {
                textMessage.setText("Settings")
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        textMessage = findViewById(R.id.message)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }
}
