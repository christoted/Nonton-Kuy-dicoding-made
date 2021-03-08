package com.example.mymovie.core.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mymovie.core.data.local.entity.Movie
import com.example.mymovie.core.data.local.entity.TvShow

@Database(entities = [Movie::class, TvShow::class], version = 2, exportSchema = false)
abstract class CatalogueDatabase : RoomDatabase() {
    abstract fun catalogueDao(): CatalogueDao

//    companion object {
//        @Volatile
//        private var INSTANCE: CatalogueDatabase? = null
//
//        fun getInstance(context: Context): CatalogueDatabase =
//            INSTANCE ?: synchronized(this) {
//                INSTANCE ?: Room.databaseBuilder(
//                    context.applicationContext,
//                    CatalogueDatabase::class.java,
//                    "catalogue.db"
//                ).fallbackToDestructiveMigration().build()
//            }
//    }
}