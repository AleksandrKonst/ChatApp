package com.example.chatapp.Repository

import com.example.chatapp.Models.AppDatabase
import com.example.chatapp.Models.Entity.Person

class PersonRepository(private val database: AppDatabase) {
    suspend fun getPersons() {
        database.personDao.getAll()
    }
    suspend fun insertPerson(person: Person) {
        database.personDao.insertAll(person)
    }
}