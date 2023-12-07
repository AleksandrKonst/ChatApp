package com.example.chatapp

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.chatapp.Data.CharacterDTO
import com.example.chatapp.Models.getDatabase
import com.example.chatapp.Presentation.ApiResponseAdapter
import com.example.chatapp.Repository.PersonRepository
import com.example.chatapp.Service.Network.KtorRepository
import com.example.chatapp.Service.StorageService
import com.example.chatapp.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch

class HomeFragment : Fragment(R.layout.fragment_home) {
    private val TAG : String = "HomeFragment"
    private val fileName : String = "characterList_11.txt"
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private var _ktorApi: KtorRepository? = null
    private val ktorApi get() = _ktorApi!!
    private lateinit var users : List<CharacterDTO>
    private val personsRepository = PersonRepository(getDatabase(requireContext()))

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        _ktorApi = KtorRepository()
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.let {
            binding.textView.setText(requireArguments().getString("name"))
        }
        if (StorageService.isFileInDownloads(fileName) ||
            StorageService.isFileInInternalStorage(requireContext(), "characterList_11.txt")){
            binding.load.visibility = View.INVISIBLE
        }

        binding.loadButton.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                StorageService.saveToDownloads(requireContext(), fileName, users.joinToString("; "))
            }
            else {
                StorageService.saveToDownloads(fileName, users.joinToString("; "))
            }
            binding.load.visibility = View.INVISIBLE
        }

        binding.settingsButton.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToSettingsFragment()
            this.findNavController().navigate(action)
        }

        lifecycleScope.launch {
            users = ktorApi.getCharacters()
            binding.characterList.adapter = ApiResponseAdapter(users)
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