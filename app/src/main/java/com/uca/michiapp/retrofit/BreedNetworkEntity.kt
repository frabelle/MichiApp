package com.uca.michiapp.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.uca.michiapp.model.Image
import com.uca.michiapp.model.Weight

data class BreedNetworkEntity(

    @SerializedName("id")
    @Expose
    var id: String,

    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("origin")
    @Expose
    var origin: String,

    @SerializedName("description")
    @Expose
    var description: String,

    @SerializedName("life_span")
    @Expose
    var life_span: String,

    @SerializedName("wikipedia_url")
    @Expose
    var wikipedia_url: String?,

    @SerializedName("image")
    @Expose
    var image: Image?,

    @SerializedName("weight")
    @Expose
    var weight: Weight,

    @SerializedName("temperament")
    @Expose
    var temperament: String
)