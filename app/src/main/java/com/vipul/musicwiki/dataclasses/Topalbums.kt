package com.vipul.musicwiki.dataclasses


import com.google.gson.annotations.SerializedName

data class Topalbums(
    val album: List<AlbumXX>,
    @SerializedName("@attr")
    val attr: AttrXXXXXXXXXX
)