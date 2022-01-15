package com.l2hyunwoo.phorest.data.model

import com.google.gson.annotations.SerializedName
import com.l2hyunwoo.phorest.domain.entity.Image

data class ImageModel(
    val id: Int,
    val author: String,
    val width: Int,
    val height: Int,
    val url: String,
    @SerializedName("download_url")
    val downloadUrl: String
) {
    fun toImage() = Image(id, author, width, height, url, downloadUrl)
}