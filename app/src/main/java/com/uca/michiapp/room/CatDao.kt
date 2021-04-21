package com.uca.michiapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CatDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(catEntity: CatCacheEntity): Long
    @Query("SELECT * FROM michis")
    suspend fun get(): List<CatCacheEntity>
}