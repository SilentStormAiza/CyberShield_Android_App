package com.example.cyberarmour.Auth

import android.content.Context
import android.content.Intent
import android.widget.Button
import android.widget.RadioButton
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cyberarmour.R

class signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.signup)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val pubRb = findViewById<RadioButton>(R.id.pub)
        val techRb = findViewById<RadioButton>(R.id.tech)
        val govtRb = findViewById<RadioButton>(R.id.govt)

        val goToSignup = findViewById<Button>(R.id.signup)
        goToSignup.setOnClickListener {
            // Determine user type at the time of click
            val userType = when {
                techRb.isChecked -> "tech"
                govtRb.isChecked -> "govt"
                else -> "pub"
            }

            // Save user type to SharedPreferences
            val sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
            with(sharedPref.edit()) {
                putString("USER_TYPE", userType)
                apply()
            }

            // Select the next activity based on userType
            val nextActivity = if (userType == "pub") {
                pub_homepg::class.java
            } else {
                homepg::class.java
            }

            val intent = Intent(this, nextActivity)
            startActivity(intent)
        }

        val backLogin = findViewById<Button>(R.id.signlogin)
        backLogin.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }
}
