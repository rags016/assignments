package com.example.unlimit.data

import com.example.unlimit.data.local.Joke
import com.example.unlimit.data.local.JokesDatabase
import com.example.unlimit.data.network.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class DataSource @Inject constructor(
    val remoteDataSource: RemoteDataSource,
    val localDataSource: JokesDatabase
) {
    suspend fun getJoke(): Flow<Result<String?>> {
        val joke = remoteDataSource.getJoke()
        if (joke.firstOrNull()?.isSuccess == true) {
            val jokeToBeSaved = joke.firstOrNull()?.getOrNull() ?: ""
            println("joke to be saved::  ${jokeToBeSaved}")
            runBlocking {
                launch(Dispatchers.IO) {
                    localDataSource.getDao().insertJoke(Joke(jokeText = jokeToBeSaved))
                }
            }
            return joke
        }
        return emptyFlow()
    }

}