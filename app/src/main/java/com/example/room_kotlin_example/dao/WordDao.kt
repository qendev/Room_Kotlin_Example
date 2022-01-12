package com.example.room_kotlin_example.dao

import androidx.room.*
import com.example.room_kotlin_example.entity.Word
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {

    //to get words in an alphabetized ascending order
    @Query("SELECT * FROM word_table ORDER BY word  ASC")
    fun getAlphabetizedWords(): Flow<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}