package com.mahdyar.rickandmorty.network

import com.mahdyar.rickandmorty.DependencyProvider
import com.mahdyar.rickandmorty.data.ApiService

object ApiClient {
    private val dependencyProvider = DependencyProvider()

    private val retrofit = dependencyProvider.provideRetrofit()

    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}

