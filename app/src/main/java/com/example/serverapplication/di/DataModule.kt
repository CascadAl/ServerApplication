package com.example.serverapplication.di

import com.example.serverapplication.data.repository.MainRepository
import com.example.serverapplication.data.repository.impl.MainRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun provideMainRepository(repository: MainRepositoryImpl): MainRepository

}