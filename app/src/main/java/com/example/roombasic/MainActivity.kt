package com.example.roombasic

import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    //    lateinit var wordDatabase: WordDatabase
//    lateinit var wordDao: WordDao
//    lateinit var allWordsLive: LiveData<List<Word>>
    lateinit var wordViewModel: WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        wordViewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory(application)
        ).get(WordViewModel::class.java)
//        wordDatabase = Room.databaseBuilder(this, WordDatabase::class.java, "word_database")
//            .allowMainThreadQueries()
//            .build()
//        wordDao = wordDatabase.getWordDao()
//        allWordsLive = wordDao.getAllWordsLive()
//        allWordsLive.observe(this, Observer {
//            val text: StringBuilder = StringBuilder()
//
//            for (word: Word in it) {
//                text.append(word.id.toString() + ":" + word.word + "=" + word.chineseMeaning + "\n")
//            }
//
//            textView.text = text
//        })

        wordViewModel.allWordsLive.observe(this, Observer {
            val text: StringBuilder = StringBuilder()

            for (word: Word in it) {
                text.append(word.id.toString() + ":" + word.word + "=" + word.chineseMeaning + "\n")
            }

            textView.text = text
        })

        btnInsert.setOnClickListener {
            val word1: Word = Word("Hello", "你好！")
            val word2: Word = Word("World", "世界！")
            wordViewModel.insertWords(word1, word2)
        }

        btnClear.setOnClickListener {
            wordViewModel.deleteAllWords()
        }

        btnUpdate.setOnClickListener {
            val word: Word = Word("Hi", "你好啊！")
            word.id = 150
            wordViewModel.updateWords(word)
        }

        btnDelete.setOnClickListener {
            val word: Word = Word("Hi", "你好啊！")
            word.id = 151
            wordViewModel.deleteWords(word)
        }
    }

}
