package com.example.unlimit.di

import com.example.unlimit.data.DataSource
import com.example.unlimit.data.network.RemoteDataSource
import com.example.unlimit.data.repository.JokeRepoImpl
import com.example.unlimit.domain.IJokeRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideJokeRepository(dataSource: DataSource): IJokeRepo {
        return JokeRepoImpl(
            dataSource
        )
    }
}