package com.example.mymovie.core.di

import com.example.mymovie.core.data.FilmRepository
import com.example.mymovie.core.domain.repository.ICatalogueRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

//@Module(includes = [NetworkModule::class, DatabaseModule::class])
@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(filmRepository: FilmRepository): ICatalogueRepository

}