package com.uca.michiapp.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.uca.michiapp.model.Image
import com.uca.michiapp.model.Weight

class Converters {

    @TypeConverter
    fun StringtoImage(value: Image?): String = Gson().toJson(value)

    @TypeConverter
    fun ImagetoString(value: String): Image? = Gson().fromJson(value, Image::class.java)

    @TypeConverter
    fun StringtoWeight(value: Weight?): String = Gson().toJson(value)

    @TypeConverter
    fun WeighttoString(value: String): Weight? = Gson().fromJson(value, Weight::class.java)

}