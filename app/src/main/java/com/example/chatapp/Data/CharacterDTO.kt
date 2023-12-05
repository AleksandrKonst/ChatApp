package com.example.chatapp.Data

import kotlinx.serialization.Serializable

@Serializable
data class CharacterDTO (
    val name: String? = null,
    val culture: String? = null,
    val born: String? = null,
    val titles: ArrayList<String> = arrayListOf(),
    var aliases: ArrayList<String> = arrayListOf(),
    var playedBy: ArrayList<String> = arrayListOf()
)