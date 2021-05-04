package com.uca.michiapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BreedDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(breedEntity: BreedCacheEntity): Long
    @Query("SELECT * FROM breeds")
    suspend fun get(): List<BreedCacheEntity>
}