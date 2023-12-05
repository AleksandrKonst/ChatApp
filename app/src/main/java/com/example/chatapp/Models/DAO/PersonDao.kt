package com.example.chatapp.Models.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.chatapp.Models.Entity.Person

@Dao
interface  PersonDao {
    @Query("SELECT * FROM person")
    fun getAll(): List<Person>

    @Query("SELECT * FROM person WHERE uid IN (:personIds)")
    fun loadAllByIds(personIds: IntArray): List<Person>

    @Query("SELECT * FROM person WHERE name LIKE :first LIMIT 1")
    fun findByName(first: String): Person

    @Insert
    fun insertAll(vararg persons: Person)

    @Delete
    fun delete(person: Person)
}