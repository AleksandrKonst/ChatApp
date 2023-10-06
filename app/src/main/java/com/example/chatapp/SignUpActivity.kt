package com.example.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
    }

    fun signUp(view: View?) {
        var nameText = findViewById(R.id.nameText) as EditText
        var emailText = findViewById(R.id.emailText) as EditText
        var passwordText = findViewById(R.id.passwordText) as EditText

        if (emailText.text.isValidEmail() || emailText.text.length > 30) {
            Toast.makeText(this, "Неверный Email", Toast.LENGTH_SHORT).show();
        } else if (passwordText.text.isNullOrEmpty() || passwordText.text.length > 20) {
            Toast.makeText(this, "Введите пароль", Toast.LENGTH_SHORT).show();
        } else if (nameText.text.isNullOrEmpty() || nameText.text.length > 30) {
            Toast.makeText(this, "Введите имя", Toast.LENGTH_SHORT).show();
        }
        else {
            val intent = Intent(this, SignInActivity::class.java)
            intent.putExtra("name", nameText.text.toString());
            intent.putExtra("email", emailText.text.toString());
            intent.putExtra("password", passwordText.text.toString());
            startActivity(intent)
        }
    }

    fun CharSequence?.isValidEmail() = !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}