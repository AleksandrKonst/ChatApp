package com.example.chatapp.Models.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Person(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    val number: Int,
    val name: String?,
    val culture: String?,
    val born: String?,
    val titles: String?,
    val aliases: String?,
    val playedBy: String?
)