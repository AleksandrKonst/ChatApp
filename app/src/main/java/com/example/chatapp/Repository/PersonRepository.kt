package com.example.chatapp.Repository

import com.example.chatapp.Models.AppDatabase
import com.example.chatapp.Models.Entity.Person
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PersonRepository(private val database: AppDatabase) {
    suspend fun getPersons(): List<Person> {
        return withContext(Dispatchers.IO) {
            database.personDao.getAll()
        }
    }
    suspend fun getPersonsByNumber(number: Int): List<Person> {
        return withContext(Dispatchers.IO) {
            database.personDao.findByNumber(number)
        }
    }
    suspend fun checkPersonInDatabase(number: Int): Boolean {
        if (withContext(Dispatchers.IO) { database.personDao.checkValue(number) } > 0){
            return true
        }
        return false
    }
    suspend fun insertPerson(person: Person) {
        withContext(Dispatchers.IO) {
            database.personDao.insert(person)
        }
    }
    suspend fun insertPersons(persons: List<Person>) {
        withContext(Dispatchers.IO) {
            database.personDao.insertAll(persons)
        }
    }
}