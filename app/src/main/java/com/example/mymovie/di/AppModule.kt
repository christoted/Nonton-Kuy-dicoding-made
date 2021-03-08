package com.example.mymovie.di

import com.example.mymovie.core.domain.usecase.CatalogueInteractor
import com.example.mymovie.core.domain.usecase.CatalogueUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideCatalogueUseCase(catalogueInteractor: CatalogueInteractor): CatalogueUseCase
}