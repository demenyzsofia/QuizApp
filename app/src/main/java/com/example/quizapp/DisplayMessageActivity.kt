package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView

class DisplayMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        val message = intent.getStringExtra(USERNAME_EXTRA)

        //megjeleniti a beirt user nevet
        val textView = findViewById<TextView>(R.id.textView_putUserName).apply {
            text = message
        }
    }
}