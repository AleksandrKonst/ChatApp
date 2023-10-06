package com.example.chatapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class OnboardFragment : Fragment(R.layout.fragment_onboard) {
    private val TAG : String = "OnboardFragment"
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.let {
            val nameText = view.findViewById<TextView>(R.id.textView)
            nameText.setText(requireArguments().getString("name"))
        }
        Log.d(TAG, "onViewCreated")
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