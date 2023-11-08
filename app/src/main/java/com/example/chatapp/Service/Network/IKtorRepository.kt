package com.example.chatapp.Service.Network

import com.example.chatapp.Data.Character

interface IKtorRepository {
    suspend fun getCharacters(): List<Character>
}