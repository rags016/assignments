package com.example.unlimit.data.local

import androidx.annotation.NonNull
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE

@Dao
interface JokeDao {

    @Insert(onConflict = REPLACE, entity = Joke::class)
    fun insertJoke(@NonNull joke: Joke)
}