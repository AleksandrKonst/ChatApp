package com.example.chatapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class OnboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboard)
    }

    fun logIn(view: View?) {
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
    }
}