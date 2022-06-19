package com.example.serverapplication.di

import com.example.serverapplication.server.ServerInitializer
import com.example.serverapplication.server.impl.ServerInitializerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ServerModule {

    @Binds
    @Singleton
    abstract fun provideServer(repository: ServerInitializerImpl): ServerInitializer

}