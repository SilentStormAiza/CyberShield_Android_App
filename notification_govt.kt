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

class notification_govt : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.notification_govt)
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
            Notification("Incident Report #452 Reviewed"),
            Notification("Review Data Leak Report for Legal further Investigation"),
            Notification("Public Awareness Campaign Launch"),
            Notification("You Closed Case #987"),
            Notification("New Advisory: Ransomware Prevention")
        )

        val recyclerView: RecyclerView = findViewById(R.id.rvNotifications)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = NotificationAdapter(notifications)
    }
}