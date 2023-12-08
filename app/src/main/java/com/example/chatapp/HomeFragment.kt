package com.example.chatapp

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.map
import androidx.navigation.fragment.findNavController
import com.example.chatapp.Data.CharacterDTO
import com.example.chatapp.Models.Entity.Person
import com.example.chatapp.Models.getDatabase
import com.example.chatapp.Presentation.ApiResponseAdapter
import com.example.chatapp.Repository.PersonRepository
import com.example.chatapp.Service.Network.KtorRepository
import com.example.chatapp.Service.StorageService
import com.example.chatapp.databinding.FragmentHomeBinding
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class HomeFragment : Fragment(R.layout.fragment_home) {
    private val TAG : String = "HomeFragment"
    private val fileName : String = "characterList_11.txt"
    private var _binding: FragmentHomeBinding? = null
    private var number:Int  = 11;
    private val binding get() = _binding!!
    private var _ktorApi: KtorRepository? = null
    private val ktorApi get() = _ktorApi!!
    private lateinit var characters : List<CharacterDTO>
    private lateinit var personsRepository : PersonRepository
    private var job : Job? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        _ktorApi = KtorRepository()
        personsRepository = PersonRepository(getDatabase(requireContext()))
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
                StorageService.saveToDownloads(requireContext(), fileName, characters.joinToString("; "))
            }
            else {
                StorageService.saveToDownloads(fileName, characters.joinToString("; "))
            }
            binding.load.visibility = View.INVISIBLE
        }

        binding.settingsButton.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToSettingsFragment()
            this.findNavController().navigate(action)
        }

        binding.sendButton.setOnClickListener {
            number = binding.numberText.text.toString().toIntOrNull()?: 11
            loadData(number)
        }

        loadData(number)

        Log.d(TAG, "onViewCreated")
    }

    private fun loadData(number: Int){
        job?.cancel()
        lifecycleScope.launch {
            if (!personsRepository.checkPersonInDatabase(number)){
                characters = ktorApi.getCharacters(number)
                binding.characterList.adapter = ApiResponseAdapter(characters)

                personsRepository.insertPersons(characters.map { characterDTO -> Person(
                    number = number,
                    name = characterDTO.name,
                    culture = characterDTO.culture,
                    born = characterDTO.born,
                    titles = characterDTO.titles?.joinToString(", "),
                    aliases = characterDTO.aliases?.joinToString(", "),
                    playedBy = characterDTO.playedBy?.joinToString(", ")
                ) })
            }
            else {
                job = lifecycleScope.launch {
                    personsRepository.getPersonsByNumber(number).collect{persons ->
                        binding.characterList.adapter = ApiResponseAdapter(persons.map { person -> CharacterDTO(
                            name = person.name,
                            culture = person.culture,
                            born = person.born,
                            titles = person.titles?.split(", "),
                            aliases = person.aliases?.split(", "),
                            playedBy = person.playedBy?.split(", ")
                        ) })
                    }
                }
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