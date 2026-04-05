package com.example.cyberarmour.Auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cyberarmour.R

class pub_homepg : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.pub_homepg)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.viewdashboard).setOnClickListener {
            startActivity(Intent(this, dashboard::class.java))
        }

        findViewById<Button>(R.id.viewnotifications).setOnClickListener {
            // For public user, this will go to notification_pub
            startActivity(Intent(this, notification_pub::class.java))
        }

        findViewById<Button>(R.id.profile).setOnClickListener {
            startActivity(Intent(this, profile::class.java))
        }

        findViewById<Button>(R.id.sendfeedback).setOnClickListener {
            startActivity(Intent(this, feedback::class.java))
        }

        findViewById<Button>(R.id.inc_rep).setOnClickListener {
            startActivity(Intent(this, inc_rep::class.java))
        }

        findViewById<Button>(R.id.logout).setOnClickListener {
            val intent = Intent(this, signup::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}
