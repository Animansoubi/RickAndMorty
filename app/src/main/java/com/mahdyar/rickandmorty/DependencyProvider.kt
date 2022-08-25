package com.mahdyar.rickandmorty

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class DependencyProvider {

    fun provideBaseUrl(): String {
        return BASE_URL
    }

    fun provideMoshi(): Moshi {
        return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }

    companion object {
        const val BASE_URL = "https://rickandmortyapi.com/api/"
    }
}