package com.uca.michiapp.di

import android.content.Context
import androidx.room.Room
import com.uca.michiapp.room.CatDao
import com.uca.michiapp.room.CatDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideCatDb(@ApplicationContext context: Context): CatDatabase{
        return Room
            .databaseBuilder(context, CatDatabase::class.java, CatDatabase.DATABASE_NAME).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideCatDao(catDatabase: CatDatabase): CatDao{
        return catDatabase.catDao()
    }
}