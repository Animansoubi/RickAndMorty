package com.mahdyar.rickandmorty

import com.mahdyar.rickandmorty.data.ApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class DependencyProvider {

    private fun provideBaseUrl(): String {
        return BASE_URL
    }

    private fun provideConverterFactory(): Moshi {
        return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }

    private fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(provideBaseUrl())
            .addConverterFactory(MoshiConverterFactory.create(provideConverterFactory()))
            .build()
    }

    fun provideRickSndMortyService(): ApiService {
        return provideRetrofit().create(ApiService::class.java)
    }

    companion object {
        const val BASE_URL = "https://rickandmortyapi.com/api/"
    }
}