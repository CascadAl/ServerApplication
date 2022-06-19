package com.example.serverapplication.di

import android.app.Application
import androidx.room.Room
import com.example.serverapplication.data.local.SaleDao
import com.example.serverapplication.data.local.TerminalDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): TerminalDatabase {
        return Room.databaseBuilder(application, TerminalDatabase::class.java, "terminal_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideSaleDao(db: TerminalDatabase): SaleDao {
        return db.getSaleDao()
    }

}