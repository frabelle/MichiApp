package com.uca.michiapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Image(
    @SerializedName("height")
    @Expose
    var height: Int,

    @SerializedName("id")
    @Expose
    var id: String,

    @SerializedName("url")
    @Expose
    var url: String,

    @SerializedName("width")
    @Expose
    var width: Int,
)