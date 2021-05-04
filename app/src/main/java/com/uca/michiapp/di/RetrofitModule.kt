package com.uca.michiapp.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.uca.michiapp.retrofit.BreedRetroFit
import com.uca.michiapp.retrofit.CatRetroFit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/v1/breeds/")
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideCatService(retrofit: Retrofit.Builder): CatRetroFit{
        return retrofit.build().create(CatRetroFit::class.java)
    }

    @Singleton
    @Provides
    fun provideBreedService(retrofit: Retrofit.Builder): BreedRetroFit{
        return retrofit.build().create(BreedRetroFit::class.java)
    }
}