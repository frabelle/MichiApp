package com.uca.michiapp.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CatNetworkEntity (
    @SerializedName("id")
    @Expose
    var id: String,

    @SerializedName("url")
    @Expose
    var url: String,

    @SerializedName("width")
    @Expose
    var width: Int,

    @SerializedName("height")
    @Expose
    var height: Int,
)