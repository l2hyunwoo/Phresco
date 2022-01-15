package com.l2hyunwoo.phorest.domain.entity

import com.l2hyunwoo.phorest.data.local.entity.ImageEntity

data class Image(
    val id: Int,
    val author: String,
    val width: Int,
    val height: Int,
    val url: String,
    val downloadUrl: String
)

fun Image.toImageEntity() = ImageEntity(id, author, width, height, url, downloadUrl)
