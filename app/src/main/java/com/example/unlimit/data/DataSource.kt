package com.example.unlimit.data

import com.example.unlimit.data.local.JokesDatabase
import com.example.unlimit.data.network.RemoteDataSource
import javax.inject.Inject

class DataSource @Inject constructor(
    val remoteDataSource: RemoteDataSource,
    val localDataSource: JokesDatabase
) {

}