package com.example.chatapp.Models

import android.content.Context
import androidx.room.*
import com.example.chatapp.Models.DAO.PersonDao
import com.example.chatapp.Models.Entity.Person

@Database(entities = [Person::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val personDao: PersonDao
}

private lateinit var INSTANCE: AppDatabase

fun getDatabase(context: Context): AppDatabase {
    synchronized(AppDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java,
                "app").build()
        }
    }
    return INSTANCE
}