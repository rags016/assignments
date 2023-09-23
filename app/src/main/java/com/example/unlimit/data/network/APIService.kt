package com.example.unlimit.data.network

import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    @GET("/api?json=format")
    fun getJoke(): Call<String>
}