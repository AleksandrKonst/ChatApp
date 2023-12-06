package com.example.chatapp.Models.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Person(
    @PrimaryKey val uid: Int,
    val number: Int,
    val name: String?,
    val culture: String?,
    val born: String?,
    val titles: ArrayList<String>,
    val aliases: ArrayList<String>,
    val playedBy: ArrayList<String>
)