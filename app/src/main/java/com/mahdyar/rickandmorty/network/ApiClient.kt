package com.mahdyar.rickandmorty.network

import com.mahdyar.rickandmorty.DependencyProvider
import com.mahdyar.rickandmorty.data.ApiService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiClient {
    private val dependencyProvider = DependencyProvider()

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(dependencyProvider.provideBaseUrl())
            .addConverterFactory(MoshiConverterFactory.create(dependencyProvider.provideMoshi()))
            .build()
    }
    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}

