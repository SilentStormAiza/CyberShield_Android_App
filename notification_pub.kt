package com.example.cyberarmour.Auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cyberarmour.R

class notification_pub : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.notification_pub)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupRecyclerView()

        findViewById<Button>(R.id.btnBack).setOnClickListener {
            val intent = Intent(this, homepg::class.java)
            startActivity(intent)
        }
    }

    private fun setupRecyclerView() {
        val notifications = listOf(
            Notification("Phishing Attack report under investigation"),
            Notification("Form submitted about Phishing attack"),
            Notification("Cyberbullying Case closed successfully"),
            Notification("Your Cyberbullying Case Closed by Crime Department"),
            Notification("Cyberbullying Case is Under investigation"),
        )

        val recyclerView: RecyclerView = findViewById(R.id.rvNotifications)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = NotificationAdapter(notifications)
    }
}