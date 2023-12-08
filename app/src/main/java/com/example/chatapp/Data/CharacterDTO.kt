package com.example.chatapp.Data

import kotlinx.serialization.Serializable

@Serializable
data class CharacterDTO(
    val name: String? = null,
    val culture: String? = null,
    val born: String? = null,
    val titles: List<String>? = arrayListOf(),
    var aliases: List<String>? = arrayListOf(),
    var playedBy: List<String>? = arrayListOf()
)