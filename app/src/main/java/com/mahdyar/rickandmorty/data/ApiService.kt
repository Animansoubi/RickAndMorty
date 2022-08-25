package com.mahdyar.rickandmorty.data

import com.mahdyar.rickandmorty.network.CharacterResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("character")
    fun fetchCharacters(@Query("page") page: String): Call<CharacterResponse>
}