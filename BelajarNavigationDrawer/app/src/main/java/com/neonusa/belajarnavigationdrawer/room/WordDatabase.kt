package com.neonusa.belajarnavigationdrawer.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Word::class], version = 1)
abstract class WordDatabase: RoomDatabase() {
    abstract fun wordDAO(): WordDAO

    companion object{
        var INSTANCE: WordDatabase? = null

        fun getInstance(context: Context): WordDatabase =
            INSTANCE ?: synchronized(this){
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    WordDatabase::class.java,
                    "words_db.db"
                ).createFromAsset("words_db.db").build()
            }

    }

}