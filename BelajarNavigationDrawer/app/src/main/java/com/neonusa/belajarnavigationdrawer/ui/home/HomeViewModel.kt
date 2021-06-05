package com.neonusa.belajarnavigationdrawer.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.neonusa.belajarnavigationdrawer.room.Word
import com.neonusa.belajarnavigationdrawer.room.WordDAO
import com.neonusa.belajarnavigationdrawer.room.WordDatabase

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private var wordDB: WordDatabase
    private var wordDAO: WordDAO

    // init digunakan untuk membuat constructor pada kotlin
    init {
        wordDB = WordDatabase.getInstance(application)
        wordDAO = wordDB.wordDAO()
    }

    fun getWords(word: String): LiveData<List<Word>> = wordDAO.getWords(word)
}