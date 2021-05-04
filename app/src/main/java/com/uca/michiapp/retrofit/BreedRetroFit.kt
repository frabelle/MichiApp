package com.uca.michiapp.retrofit

import retrofit2.http.GET

interface BreedRetroFit {
    @GET("search")
    suspend fun get(): List<BreedRetroFit>
}