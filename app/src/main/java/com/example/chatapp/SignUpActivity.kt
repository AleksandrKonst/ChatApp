package com.example.chatapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.chatapp.Service.isValidEmail
import com.example.chatapp.Service.isValidName
import com.example.chatapp.Service.isValidPassword

class SignUpActivity : AppCompatActivity() {
    private val TAG : String = "SignUpActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        Log.d(TAG, "onCreate")
    }

    fun signUp(view: View?) {
        var nameText = findViewById(R.id.nameText) as EditText
        var emailText = findViewById(R.id.emailText) as EditText
        var passwordText = findViewById(R.id.passwordText) as EditText

        if (!nameText.text.isValidName()) {
            Toast.makeText(this, "Введите корректное имя", Toast.LENGTH_SHORT).show()
        } else if (!emailText.text.isValidEmail()) {
            Toast.makeText(this, "Введите корректный Email", Toast.LENGTH_SHORT).show();
        } else if (!passwordText.text.isValidPassword()) {
            Toast.makeText(this, "Введите корректный пароль", Toast.LENGTH_SHORT).show()
        }
        else {
            val intent = Intent(this, SignInActivity::class.java)

            intent.putExtra("name", nameText.text.toString());
            intent.putExtra("email", emailText.text.toString());
            intent.putExtra("password", passwordText.text.toString());

            startActivity(intent)
        }
    }
}