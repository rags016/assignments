package com.example.unlimit.data.repository

import com.example.unlimit.data.DataSource
import com.example.unlimit.domain.IJokeRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class JokeRepoImpl @Inject constructor(val dataSource: DataSource) : IJokeRepo {
    override suspend fun getJoke(): Flow<Result<String?>> {
       return  dataSource.getJoke()
    }

}