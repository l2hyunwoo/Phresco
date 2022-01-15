package com.l2hyunwoo.phorest.domain.entity

data class Image(
    val id: Int,
    val author: String,
    val width: Int,
    val height: Int,
    val url: String,
    val downloadUrl: String
)
