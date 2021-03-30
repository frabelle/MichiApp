package com.uca.michiapp.retrofit

import retrofit2.http.GET

interface CatRetroFit {
    @GET("search")
    suspend fun get(): List<CatNetworkEntity>
}