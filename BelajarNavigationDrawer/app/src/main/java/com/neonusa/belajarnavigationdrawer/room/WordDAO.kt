package com.neonusa.belajarnavigationdrawer.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update

@Dao
interface WordDAO{
//    @Query("SELECT * FROM tbl_words")
//    fun getWords(): LiveData<List<Word>>

    @Update(entity = Word::class)
    fun updateWord(word: Word)

    @Query("SELECT * FROM tbl_words WHERE word LIKE :search")
    fun getWords(search: String?): LiveData<List<Word>>
}