package com.example.unlimit.domain

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class JokeUseCase @Inject constructor(private val iJokeRepo: IJokeRepo) {

    suspend fun getJoke(): Flow<Result<String?>> {
        return iJokeRepo.getJoke()
    }


}