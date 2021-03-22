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
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DatabaseModule {

    val passphrase: ByteArray = SQLiteDatabase.getBytes("catalogue".toCharArray())
    val factory = SupportFactory(passphrase)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): CatalogueDatabase  =
        // Add Encryption
         Room.databaseBuilder(
            context,
            CatalogueDatabase::class.java, "catalogueTest.db"
        ).fallbackToDestructiveMigration().openHelperFactory(factory).build()


    @Provides
    fun provideCatalogueDAO(database: CatalogueDatabase): CatalogueDao = database.catalogueDao()
}