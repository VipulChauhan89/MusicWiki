package com.vipul.musicwiki.dataclasses


import com.google.gson.annotations.SerializedName

data class ImageXXX(
    val size: String,
    @SerializedName("#text")
    val text: String
)