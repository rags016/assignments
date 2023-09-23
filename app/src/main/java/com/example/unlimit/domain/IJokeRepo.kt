package com.example.unlimit.domain

import kotlinx.coroutines.flow.Flow

interface IJokeRepo {
    suspend fun getJoke(): Flow<Result<String?>>
}