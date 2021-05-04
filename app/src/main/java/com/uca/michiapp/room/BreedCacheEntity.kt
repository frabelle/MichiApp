package com.uca.michiapp.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.uca.michiapp.model.Image
import com.uca.michiapp.model.Weight

@Entity(tableName = "breeds")
class BreedCacheEntity (

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "origin")
    var origin: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "life_span")
    var life_span: String,

    @ColumnInfo(name = "wikipedia_url")
    var wikipedia_url: String?,

    @ColumnInfo(name = "image")
    var image: Image?,

    @ColumnInfo(name = "weight")
    var weight: Weight

    )