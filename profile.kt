package com.example.cyberarmour.Auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cyberarmour.R
import com.google.android.material.snackbar.Snackbar

class profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val saveBtn = findViewById<Button>(R.id.savechanges)
        saveBtn.setOnClickListener {
            Snackbar.make(
                it,
                "Profile Updated!",
                Snackbar.LENGTH_SHORT
            ).show()
        }

        val backToHomeBtn = findViewById<Button>(R.id.profhome)
        backToHomeBtn.setOnClickListener {
            val intent = Intent(this, homepg::class.java)
            startActivity(intent)
        }
    }
}
