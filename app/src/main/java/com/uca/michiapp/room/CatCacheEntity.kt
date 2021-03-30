package com.uca.michiapp.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "michis")
class CatCacheEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: String,

    @ColumnInfo(name = "url")
    var url: String,

    @ColumnInfo(name = "width")
    var width: Int,

    @ColumnInfo(name = "height")
    var height: Int
)