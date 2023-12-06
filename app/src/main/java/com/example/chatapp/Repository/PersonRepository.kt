package com.example.chatapp.Repository

import android.content.Context
import com.example.chatapp.Models.AppDatabase
import com.example.chatapp.Models.DAO.PersonDao
import com.example.chatapp.Models.Entity.Person

class PersonRepository(private val database: AppDatabase) {
    val allPerson: List<Person> = database.personDao().getAll()

    suspend fun insert(person: Person) {
        database.personDao().insertAll(person)
    }
}