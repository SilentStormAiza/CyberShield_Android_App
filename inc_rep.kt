package com.example.cyberarmour.Auth

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cyberarmour.R

class inc_rep : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.inc_rep)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val submitBtn = findViewById<Button>(R.id.submitreport)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar3)

        submitBtn.setOnClickListener {
            // Show progress bar and hide button
            progressBar.visibility = View.VISIBLE
            submitBtn.visibility = View.GONE

            // Simulate submission delay
            Handler(Looper.getMainLooper()).postDelayed({
                progressBar.visibility = View.GONE
                submitBtn.visibility = View.VISIBLE
                showReportSuccessPopup()
            }, 2000) // 2 second delay
        }
    }

    private fun showReportSuccessPopup() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.popup_report)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val messageTv = dialog.findViewById<TextView>(R.id.popupMessage)
        val okayBtn = dialog.findViewById<Button>(R.id.btnOkay)

        messageTv.text = "You report have been submitted successfully!"
        okayBtn.text = "Okay"

        okayBtn.setOnClickListener {
            dialog.dismiss()
            val intent = Intent(this, homepg::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }

        dialog.show()
    }
}