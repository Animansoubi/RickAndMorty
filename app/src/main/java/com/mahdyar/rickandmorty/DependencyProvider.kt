package com.mahdyar.rickandmorty

class DependencyProvider {

    fun provideBaseUrl(): String {
        return BASE_URL
    }

    companion object {
        const val BASE_URL = "https://rickandmortyapi.com/api/"
    }
}