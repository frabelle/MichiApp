package com.uca.michiapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.uca.michiapp.utils.Converters

@Database(entities = [CatCacheEntity::class, BreedCacheEntity::class], version = 3)
@TypeConverters(Converters::class)
abstract class CatDatabase: RoomDatabase() {
    companion object{
        val DATABASE_NAME = "MichisDB"
    }

    abstract fun catDao(): CatDao
    abstract fun breedDao(): BreedDao
}