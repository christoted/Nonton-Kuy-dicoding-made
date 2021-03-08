package com.example.mymovie.core.di

import android.content.Context
import androidx.room.Room
import com.example.mymovie.core.data.local.room.CatalogueDao
import com.example.mymovie.core.data.local.room.CatalogueDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): CatalogueDatabase = Room.databaseBuilder(
        context,
        CatalogueDatabase::class.java, "catalogue.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideCatalogueDAO(database: CatalogueDatabase): CatalogueDao = database.catalogueDao()
}