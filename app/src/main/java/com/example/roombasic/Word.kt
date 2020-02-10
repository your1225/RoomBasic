package com.example.roombasic

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Word(word: String, chineseMeaning:String) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    @ColumnInfo(name = "english_word")
    var word: String
    @ColumnInfo(name = "chinese_meaning")
    var chineseMeaning: String

    init {
        this.word = word
        this.chineseMeaning = chineseMeaning
    }
}