package com.vipul.musicwiki.dataclasses


data class Bio(
    val content: String,
    val links: Links,
    val published: String,
    val summary: String
)