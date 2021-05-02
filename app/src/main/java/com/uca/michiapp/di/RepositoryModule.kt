package com.uca.michiapp.di

import com.uca.michiapp.repository.CatRepository
import com.uca.michiapp.retrofit.CatRetroFit
import com.uca.michiapp.retrofit.NetworkMapper
import com.uca.michiapp.room.CacheMapper
import com.uca.michiapp.room.CatDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideCatRepository(
        catDao: CatDao,
        catRetroFit: CatRetroFit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): CatRepository {
        return CatRepository(catDao, catRetroFit, cacheMapper, networkMapper)
    }
}