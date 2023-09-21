package com.example.unlimit.di

import android.content.Context
import androidx.room.Room
import com.example.unlimit.data.local.JokesDatabase
import com.example.unlimit.data.local.JokeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    private val databaseName by lazy { "joke-db" }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): JokesDatabase {
        return Room.databaseBuilder(context, JokesDatabase::class.java, databaseName).build()
    }

    @Provides
    @Singleton
    fun provideDao(dataBase: JokesDatabase): JokeDao {
        return dataBase.getDao()
    }
}