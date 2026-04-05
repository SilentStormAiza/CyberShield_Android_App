package com.example.cyberarmour.Auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cyberarmour.R

class dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.dashboard)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // F4: Initial Fragment Transaction
        // We load the ScamListFragment into the container when the activity starts
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ScamListFragment())
                .commit()
        }

        findViewById<Button>(R.id.dashhome).setOnClickListener {
            val intent = Intent(this, homepg::class.java)
            startActivity(intent)
            finish()
        }
    }

    /**
     * F2 & F4: This function handles switching from List to Detail
     * It uses FragmentTransaction and passes the Scam object via Bundle
     */
    fun showScamDetail(scam: Scam) {
        val detailFragment = ScamDetailFragment.newInstance(scam)
        
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, detailFragment)
            .addToBackStack(null) // Allows the user to use the back button to return to the list
            .commit()
    }
}
