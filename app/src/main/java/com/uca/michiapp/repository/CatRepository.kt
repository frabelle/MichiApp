package com.uca.michiapp.repository

import com.uca.michiapp.retrofit.CatRetroFit
import com.uca.michiapp.retrofit.NetworkMapper
import com.uca.michiapp.room.CacheMapper
import com.uca.michiapp.room.CatDao
import com.uca.michiapp.utils.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.UnknownHostException

class CatRepository(
private val catDao: CatDao,
private val catRetroFit: CatRetroFit,
private val cacheMapper: CacheMapper,
private val networkMapper: NetworkMapper
) {
    suspend fun getCats(): kotlinx.coroutines.flow.Flow<DataState> = flow {
        emit(DataState.Loading)
        delay(1000)
        try {
            val catData = catRetroFit.get()
            val catMap = networkMapper.mapFromEntityList(catData)

            for (tempCat in catMap) {
                catDao.insert(cacheMapper.mapToEntity(tempCat))
            }

            val cacheCat = catDao.get()
            emit(DataState.SuccessCat(cacheMapper.mapFromEntityList(cacheCat)))

        }catch (e: Exception){
            if(e is HttpException || e is HttpURLConnection || e is UnknownHostException){
                val cacheCat = catDao.get()
                emit(DataState.SuccessCat(cacheMapper.mapFromEntityList(cacheCat)))
            }
            else{
                emit(DataState.Error(e))
            }
        }
    }
}