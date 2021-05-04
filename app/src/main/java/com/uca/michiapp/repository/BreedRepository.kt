package com.uca.michiapp.repository

import com.uca.michiapp.retrofit.BreedNetworkMapper
import com.uca.michiapp.retrofit.BreedRetroFit
import com.uca.michiapp.room.BreedCacheMapper
import com.uca.michiapp.room.BreedDao
import com.uca.michiapp.utils.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class BreedRepository (
    private val breedDao: BreedDao,
    private val breedRetroFit: BreedRetroFit,
    private val breedCacheMapper: BreedCacheMapper,
    private val breedNetworkMapper: BreedNetworkMapper
){
    suspend fun getBreeds(): kotlinx.coroutines.flow.Flow<DataState> = flow {
        emit(DataState.Loading)
        delay(1000)
        try {
            val breedData = breedRetroFit.get()
            val breedMap = breedNetworkMapper.mapfromEntityListBreed(breedData)

            for (tempBreed in breedMap){
                breedDao.insert(breedCacheMapper.mapToEntity(tempBreed))
            }

            val cacheBreed = breedDao.get()
            emit(DataState.SuccessBreed(breedCacheMapper.mapFromEntityListBreed(cacheBreed)))
        }catch (e: Exception){
            emit(DataState.Error(e))
        }

    }
}