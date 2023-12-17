package com.example.chatapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.chatapp.Service.ForegroundService.NotificationService
import com.example.chatapp.databinding.FragmentOnboardBinding

class OnboardFragment : Fragment(R.layout.fragment_onboard) {
    private val TAG : String = "OnboardFragment"
    private var _binding: FragmentOnboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnboardBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(TAG, "onViewCreated")
        binding.elevatedButton.setOnClickListener {
            val action = OnboardFragmentDirections.actionOnboardFragmentToSignInFragment()
            this.findNavController().navigate(action)
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

        val serviceIntent = Intent(requireContext(), NotificationService::class.java)
        requireContext().startService(serviceIntent)
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")

        val serviceIntent = Intent(requireContext(), NotificationService::class.java)
        requireContext().stopService(serviceIntent)
    }
}