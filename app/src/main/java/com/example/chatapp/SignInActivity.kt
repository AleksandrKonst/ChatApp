package com.example.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
    }

    fun logIn(view: View?) {
        var emailText = findViewById(R.id.emailText) as EditText
        var passwordText = findViewById(R.id.passwordText) as EditText
        if (!emailText.text.isValidEmail()) {
            Toast.makeText(this, "Неверный Email", Toast.LENGTH_SHORT).show();
        } else if (passwordText.text.isNullOrEmpty() || passwordText.text.length > 20) {
            Toast.makeText(this, "Введите пароль", Toast.LENGTH_SHORT).show();
        }
        else {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    fun CharSequence?.isValidEmail() = !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}