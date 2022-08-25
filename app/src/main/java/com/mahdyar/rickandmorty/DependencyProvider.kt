package com.mahdyar.rickandmorty

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class DependencyProvider {

    fun provideBaseUrl(): String {
        return BASE_URL
    }

    fun provideMoshi(): Moshi {
        return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }

    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(provideBaseUrl())
            .addConverterFactory(MoshiConverterFactory.create(provideMoshi()))
            .build()
    }

    companion object {
        const val BASE_URL = "https://rickandmortyapi.com/api/"
    }
}