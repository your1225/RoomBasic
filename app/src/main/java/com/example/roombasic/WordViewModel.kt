package com.example.roombasic

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class WordViewModel(application: Application) : AndroidViewModel(application) {
    lateinit var allWordsLive: LiveData<List<Word>>
    lateinit var wordRepository: WordRepository

    init {
        wordRepository = WordRepository(application)
        allWordsLive = wordRepository.allWordsLive
    }

    fun insertWords(vararg words: Word){
        wordRepository.insertWords(*words)
    }

    fun updateWords(vararg words: Word){
        wordRepository.updateWords(*words)
    }

    fun deleteWords(vararg words: Word){
        wordRepository.deleteWords(*words)
    }

    fun deleteAllWords(){
        wordRepository.deleteAllWords()
    }
}