package com.example.chatapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.chatapp.Service.isValidEmail
import com.example.chatapp.Service.isValidName
import com.example.chatapp.Service.isValidPassword
import com.example.chatapp.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {
    private val TAG : String = "SignUpFragment"
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(TAG, "SignUpCreated")
        binding.signUpButton.setOnClickListener {
            if (!binding.nameText.text.isValidName()) {
                Toast.makeText(this.activity, "Введите корректное имя", Toast.LENGTH_SHORT).show()
            } else if (!binding.emailText.text.isValidEmail()) {
                Toast.makeText(this.activity, "Введите корректный Email", Toast.LENGTH_SHORT).show();
            } else if (!binding.passwordText.text.isValidPassword()) {
                Toast.makeText(this.activity, "Введите корректный пароль", Toast.LENGTH_SHORT).show()
            }
            else {
                val bundle = bundleOf("name" to binding.nameText.text.toString(), "email" to binding.emailText.text.toString(), "password" to binding.passwordText.text.toString())

                parentFragmentManager.commit {
                    replace<SignInFragment>(R.id.fragmentContainerView, args = bundle)
                    setReorderingAllowed(true)
                }

                Toast.makeText(this.activity, "${binding.nameText.text} успешно зарегестрирован", Toast.LENGTH_SHORT).show();
            }
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