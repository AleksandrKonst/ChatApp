package com.example.chatapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.fragment.app.Fragment


class SignInFragment : Fragment(R.layout.fragment_sign_in) {
    private val TAG : String = "SignInFragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.let {
            val nameText = view.findViewById<EditText>(R.id.nameText)
            val emailText = view.findViewById<EditText>(R.id.emailText)
            val passwordText = view.findViewById<EditText>(R.id.passwordText)

            emailText.setText(requireArguments().getString("email"))
            passwordText.setText(requireArguments().getString("password"))
            Log.d(TAG, "onViewCreated")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }
}