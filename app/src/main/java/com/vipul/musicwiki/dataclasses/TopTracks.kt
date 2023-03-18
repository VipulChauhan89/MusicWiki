package com.vipul.musicwiki.dataclasses

import com.google.gson.annotations.SerializedName

data class TopTracks(
    @SerializedName("@attr")
    val attr: AttrXXXXX,
    val track: List<Track>
)
