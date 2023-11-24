package com.example.chatapp.Presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.Data.Character
import com.example.chatapp.databinding.ListItemBinding

class ApiResponseAdapter(private var items: List<Character>) :
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
    fun setData(newData: List<Character>) {
        this.items = newData
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(character: Character) {
            with(binding) {
                nameTextView.text = if (character.name != "") character.name else "Нет данных"
                cultureTextView.text = "[culture] " + if (character.culture != "") character.culture else "Нет данных"
                bornTextView.text = "[born] " + if (character.born != "") character.born else "Нет данных"
                aliasesTextView.text = "[titles] " + if (character.aliases.joinToString(", ") != "") character.aliases.joinToString(", ") else "Нет данных"
                titlesTextView.text = "[aliases] " + if (character.titles.joinToString(", ") != "") character.titles.joinToString(", ") else "Нет данных"
                playedByNameTextView.text = "[playedBy] " + if (character.playedBy.joinToString(", ") != "") character.playedBy.joinToString(", ") else "Нет данных"
            }
        }
    }
}