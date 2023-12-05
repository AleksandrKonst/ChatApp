package com.example.chatapp.Service.Network

import com.example.chatapp.Data.CharacterDTO

interface IKtorRepository {
    suspend fun getCharacters(): List<CharacterDTO>
}