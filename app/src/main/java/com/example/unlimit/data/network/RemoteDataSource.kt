package com.example.unlimit.data.network

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import retrofit2.awaitResponse
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: APIService) {
    suspend fun getJoke(): Flow<Result<String?>> {
        val response = apiService.getJoke().awaitResponse()
        return if (response.isSuccessful) {
            flowOf(Result.success(response.body()))
        } else {
            flowOf(Result.failure(Throwable("API Error: ${response.code()}")))
        }
    }

}