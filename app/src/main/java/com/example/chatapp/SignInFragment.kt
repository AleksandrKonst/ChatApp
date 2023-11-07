package com.example.chatapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.chatapp.Service.isValidEmail
import com.example.chatapp.Service.isValidPassword
import com.example.chatapp.databinding.FragmentSignInBinding

class SignInFragment : Fragment(R.layout.fragment_sign_in) {
    private val TAG : String = "SignInFragment"
    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!
    private val args: SignInFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.emailText.setText(args.email)
        binding.passwordText.setText(args.password)
        Log.d(TAG, "onViewCreated")

        binding.registration.setOnClickListener {
            val action = SignInFragmentDirections.actionSignInFragmentToSignUpFragment()
            this.findNavController().navigate(action)
        }

        binding.signUpButton.setOnClickListener {
            if (!binding.emailText.text.isValidEmail()) {
                Toast.makeText(this.activity, "Введите корректный Email", Toast.LENGTH_SHORT).show();
            } else if (!binding.passwordText.text.isValidPassword()) {
                Toast.makeText(this.activity, "Введите корректный пароль", Toast.LENGTH_SHORT).show();
            }
            else {
                val action = SignInFragmentDirections.actionSignInFragmentToHomeFragment(args.name)
                this.findNavController().navigate(action)
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