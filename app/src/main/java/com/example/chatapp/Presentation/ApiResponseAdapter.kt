package com.example.chatapp.Presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.Data.CharacterDTO
import com.example.chatapp.databinding.ListItemBinding

class ApiResponseAdapter(private var items: List<CharacterDTO>) :
    RecyclerView.Adapter<ApiResponseAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newData: List<CharacterDTO>) {
        this.items = newData
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(characterDTO: CharacterDTO) {
            with(binding) {
                nameTextView.text = if (characterDTO.name != "") characterDTO.name else "Нет данных"
                cultureTextView.text = "[culture] " + if (characterDTO.culture != "") characterDTO.culture else "Нет данных"
                bornTextView.text = "[born] " + if (characterDTO.born != "") characterDTO.born else "Нет данных"
                aliasesTextView.text = "[titles] " + if (characterDTO.aliases.joinToString(", ") != "") characterDTO.aliases.joinToString(", ") else "Нет данных"
                titlesTextView.text = "[aliases] " + if (characterDTO.titles.joinToString(", ") != "") characterDTO.titles.joinToString(", ") else "Нет данных"
                playedByNameTextView.text = "[playedBy] " + if (characterDTO.playedBy.joinToString(", ") != "") characterDTO.playedBy.joinToString(", ") else "Нет данных"
            }
        }
    }
}