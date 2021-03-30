package com.uca.michiapp.room

import androidx.room.RoomDatabase

abstract class CatDatabase: RoomDatabase() {
    companion object{
        val DATABASE_NAME = "MichisDB"
    }

    abstract fun catDao(): CatDao
}