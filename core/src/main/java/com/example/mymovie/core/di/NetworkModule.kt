package com.example.mymovie.core.di

import com.example.mymovie.core.data.remote.api.CatalogueApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ApplicationComponent::class)
class NetworkModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient {

        val hostName = "www.omdapi.com"
        val certificatePinner = CertificatePinner.Builder()
            .add(hostName, "sha256/qPerI4uMwY1VrtRE5aBY8jIQJopLUuBt2+GDUWMwZn4==")
            .build()

        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).certificatePinner(certificatePinner)
            .build()
    }

    @Provides
    fun provideApiService(client: OkHttpClient): CatalogueApi {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.omdbapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        return retrofit.create(CatalogueApi::class.java)
    }
}