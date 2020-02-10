package com.example.roombasic

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//singleton
@Database(entities = [(Word::class)], version = 1, exportSchema = false)
abstract class WordDatabase() : RoomDatabase() {

    companion object {
        private var INSTANCE: WordDatabase? = null

        @Synchronized
        fun getInstance(context: Context): WordDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext, WordDatabase::class.java, "word_database")
                    .build()
            }

            return INSTANCE!!
        }
    }

    abstract fun getWordDao(): WordDao
}