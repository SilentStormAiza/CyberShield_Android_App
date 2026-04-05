package com.example.cyberarmour.Auth

import android.content.Context
import android.content.Intent
import android.widget.Button
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cyberarmour.R

class homepg : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.homepg)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val goToLogout = findViewById<Button>(R.id.logout)
        goToLogout.setOnClickListener {
            val intent = Intent(this, signup::class.java)
            startActivity(intent)
        }
        val goToProfile = findViewById<Button>(R.id.profile)
        goToProfile.setOnClickListener {
            val intent = Intent(this, profile::class.java)
            startActivity(intent)
        }
        val goToDashboard = findViewById<Button>(R.id.viewdashboard)
        goToDashboard.setOnClickListener {
            val intent = Intent(this, dashboard::class.java)
            startActivity(intent)
        }
        val goToNotifications = findViewById<Button>(R.id.viewnotifications)
        goToNotifications.setOnClickListener {
            val sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
            val userType = sharedPref.getString("USER_TYPE", "pub")

            val notificationClass = when (userType) {
                "tech" -> notification_tech::class.java
                "govt" -> notification_govt::class.java
                else -> notification_pub::class.java
            }
            val intent = Intent(this, notificationClass)
            startActivity(intent)
        }
        val goToFeedback = findViewById<Button>(R.id.sendfeedback)
        goToFeedback.setOnClickListener {
            val intent = Intent(this, feedback::class.java)
            startActivity(intent)
        }
    }
}
