package com.uca.michiapp.di

import com.uca.michiapp.repository.CatRepository
import com.uca.michiapp.retrofit.CatRetroFit
import com.uca.michiapp.retrofit.NetworkMapper
import com.uca.michiapp.room.CacheMapper
import com.uca.michiapp.room.CatDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton

@InstallIn
@Module
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