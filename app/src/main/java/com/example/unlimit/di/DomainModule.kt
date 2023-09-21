package com.example.unlimit.di

import com.example.unlimit.data.DataSource
import com.example.unlimit.data.repository.JokeRepoImpl
import com.example.unlimit.domain.IJokeRepo
import com.example.unlimit.domain.JokeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideJokeUseCase(iJokeRepo: IJokeRepo): JokeUseCase {
        return JokeUseCase(iJokeRepo)
    }
}