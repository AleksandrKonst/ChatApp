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

    @Query("SELECT * FROM person WHERE number = :first")
    fun findByNumber(first: Int): List<Person>

    @Query("SELECT COUNT(*) FROM person WHERE number = :first")
    fun checkValue(first: Int): Int

    @Insert
    fun insert(vararg person: Person)
    @Insert
    fun insertAll(person: List<Person>)

    @Delete
    fun delete(person: Person)
}