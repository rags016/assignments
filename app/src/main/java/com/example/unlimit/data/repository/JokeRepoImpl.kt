package com.example.unlimit.data.repository

import com.example.unlimit.data.DataSource
import com.example.unlimit.domain.IJokeRepo
import javax.inject.Inject

class JokeRepoImpl @Inject constructor(val dataSource: DataSource) : IJokeRepo {

}